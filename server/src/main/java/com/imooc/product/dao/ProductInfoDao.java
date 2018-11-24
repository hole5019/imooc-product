package com.imooc.product.dao;

import com.imooc.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by helei on 2018-11-14.
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String>{

    List<ProductInfo> findByProductStatus(Integer status);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);

}
