package com.imooc.product.service;

import com.imooc.product.dto.CartDTO;
import com.imooc.product.entity.ProductInfo;

import java.util.List;

/**
 * Created by helei on 2018-11-14.
 */
public interface ProductService {
    public List<ProductInfo> findAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList);

    /**
     * 扣除商品库存
     * @param cartDTOList
     */
    public void decreaseStock(List<CartDTO> cartDTOList);
}
