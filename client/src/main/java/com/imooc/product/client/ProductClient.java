package com.imooc.product.client;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by helei on 2018-11-16.
 */
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

}
