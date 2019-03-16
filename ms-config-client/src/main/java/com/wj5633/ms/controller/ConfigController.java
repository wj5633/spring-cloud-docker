package com.wj5633.ms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/16 2:01
 * @description
 */

@RestController
@RefreshScope
public class ConfigController {

    @Value("${profile}")
    private String profile;

    @GetMapping("/profile")
    public String hello() {
        return profile;
    }
}
