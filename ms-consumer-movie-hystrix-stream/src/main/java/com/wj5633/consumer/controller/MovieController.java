package com.wj5633.consumer.controller;

import com.wj5633.common.vo.User;
import com.wj5633.consumer.service.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/12 3:31
 * @description
 */

@Slf4j
@RestController
public class MovieController {

    private final RestTemplate restTemplate;
    private final LoadBalancerClient loadBalancerClient;
    private final UserFeignClient userFeignClient;

    @Autowired
    public MovieController(RestTemplate restTemplate,
                           UserFeignClient userFeignClient,
                           LoadBalancerClient loadBalancerClient) {
        this.restTemplate = restTemplate;
        this.userFeignClient = userFeignClient;
        this.loadBalancerClient = loadBalancerClient;
    }

    /* @HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = {
             @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
             @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
             @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1000")
     }, threadPoolProperties = {
             @HystrixProperty(name = "coreSize", value = "1"),
             @HystrixProperty(name = "maxQueueSize", value = "10")
     })*/
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
//        return restTemplate.getForObject("http://ms-provider/user/" + id, User.class);
        return userFeignClient.findById(id);
    }

    /*public User findByIdFallback(@PathVariable Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("default");
        return user;
    }*/

    @GetMapping("/log-user-instance")
    public void showInfo() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("ms-eureka");

        log.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

}
