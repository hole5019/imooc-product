package com.imooc.product.utils;

import com.imooc.product.vo.ResultVo;

/**
 * Created by helei on 2018-11-14.
 */
public class ResultVoUtil {

    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setData(object);
        resultVo.setCode(0);
        resultVo.setMsg("成功3gggggg");
        return resultVo;
    }
}
