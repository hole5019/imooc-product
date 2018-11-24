package com.imooc.product.dao;

import com.imooc.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by helei on 2018-11-14.
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
