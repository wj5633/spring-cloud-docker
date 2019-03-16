package com.wj5633.ms.config;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/15 22:26
 * @description
 */

@Configuration
public class ZuulConfiguration {

    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper("(?<name>^,+)-(?<version>v.+$", "${version}/${name}");
    }
}
