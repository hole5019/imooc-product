package com.imooc.product.controller;

import com.imooc.product.dto.CartDTO;
import com.imooc.product.entity.ProductCategory;
import com.imooc.product.entity.ProductInfo;
import com.imooc.product.service.CategoryService;
import com.imooc.product.service.ProductService;
import com.imooc.product.utils.ResultVoUtil;
import com.imooc.product.vo.ProductInfoVo;
import com.imooc.product.vo.ProductVo;
import com.imooc.product.vo.ResultVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by helei on 2018-11-14.
 */
@RestController
@RequestMapping("/product")
public class ProductInfoController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */
    @ResponseBody
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<ProductVo> list() {
        ResultVo resultVo = new ResultVo();
        //1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findAll();
        //2. 获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //3. 查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //4. 构造数据
        List<ProductVo> productVoList = new ArrayList<>();
        if(categoryList.size() > 0){
            for(ProductCategory productCategory : categoryList){
                ProductVo productVo = new ProductVo();
                productVo.setCategoryName(productCategory.getCategoryName());
                productVo.setCategoryType(productCategory.getCategoryType());

                List<ProductInfoVo> productInfoVoList = new ArrayList<>();
                if(productInfoList.size() > 0){
                    for(ProductInfo productInfo : productInfoList){
                        if( productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                            ProductInfoVo productInfoVo = new ProductInfoVo();
                            BeanUtils.copyProperties(productInfo,productInfoVo);
                            productInfoVoList.add(productInfoVo);
                        }
                    }
                }
                productVo.setProductInfoVoList(productInfoVoList);
                productVoList.add(productVo);
            }
        }

        return ResultVoUtil.success(productVoList);
    }

    /**
     * 获取商品列表（提供给订单服务调用）
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){

        return productService.findByProductIdIn(productIdList);
    }

    /**
     * 扣库存
     * @param cartDTOList
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
        productService.decreaseStock(cartDTOList);
    }
}
