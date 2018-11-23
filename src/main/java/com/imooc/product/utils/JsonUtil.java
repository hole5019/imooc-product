package com.imooc.product.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by helei on 2018-11-22.
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 转换为json字符串
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json转对象
     * @param jsonStr
     * @param obj
     * @return
     */
    public static Object fromJson(String jsonStr,Object obj) {
        try {
            return obj = objectMapper.readValue(jsonStr, obj.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
