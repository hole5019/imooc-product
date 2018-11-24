package com.imooc.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by helei on 2018-11-15.
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "this is product msg2";
    }
}
