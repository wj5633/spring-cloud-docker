package com.wj5633.consumer.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/13 23:22
 * @description
 */

@Configuration
public class RibbonConfiguration {

//    @Bean
//    public IRule ribbonRule() {
//        return new RandomRule();
//    }

   /* @Bean
    @ConditionalOnBean
    public IRule ribbonRule(IClientConfig config) {
        ZoneAvoidanceRule rule = new ZoneAvoidanceRule();
        rule.initWithNiwsConfig(config);
        return rule;
    }*/
}
