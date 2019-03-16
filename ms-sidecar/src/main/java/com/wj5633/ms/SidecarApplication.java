package com.wj5633.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/15 23:36
 * @description
 */

@SpringBootApplication
@EnableSidecar
public class SidecarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SidecarApplication.class, args);
    }
}
