package com.imooc.product.service;

import com.imooc.product.entity.ProductCategory;

import java.util.List;

/**
 * Created by helei on 2018-11-14.
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
