package com.imooc.product.dao;

import com.imooc.product.ImoocProductApplicationTests;
import com.imooc.product.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by helei on 2018-11-14.
 */
@Component
public class ProductInfoDaoTest extends ImoocProductApplicationTests {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> list = productInfoDao.findByProductStatus(0);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findByProductIdIn() throws Exception {
        List<ProductInfo> list = productInfoDao.findByProductIdIn(Arrays.asList("157875196366160022","157875227953464068"));
        Assert.assertTrue(list.size()>0);
    }

}