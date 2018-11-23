package com.imooc.product.enums;

import lombok.Getter;

/**
 * 商品上下架状态
 * Created by helei on 2018-11-14.
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
