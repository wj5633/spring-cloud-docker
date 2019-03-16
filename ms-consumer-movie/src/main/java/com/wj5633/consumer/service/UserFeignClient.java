package com.wj5633.consumer.service;

import com.wj5633.common.vo.User;
import com.wj5633.consumer.config.FeignConfiguration;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/13 23:44
 * @description
 */

@FeignClient(name = "ms-provider", configuration = FeignConfiguration.class,
        fallback = FeignClientFallback.class/*,
        fallbackFactory = FeignClientFallbackFactory.class*/)
public interface UserFeignClient {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//    @RequestLine("GET /user/{id}")
    User findById(@PathVariable("id") Long id);

}


@Component
class FeignClientFallback implements UserFeignClient {

    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setUsername("default");
        return user;
    }
}

@Slf4j
@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {


    @Override
    public UserFeignClient create(Throwable throwable) {
        return id -> {
            log.info("fallback: reason was: ", throwable);
            User user = new User();
            user.setId(-1L);
            user.setUsername("default");
            return user;
        };
    }
}