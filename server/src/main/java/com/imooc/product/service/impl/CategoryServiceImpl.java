package com.imooc.product.service.impl;

import com.imooc.product.entity.ProductCategory;
import com.imooc.product.service.CategoryService;
import com.imooc.product.dao.ProductCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by helei on 2018-11-14.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }
}
