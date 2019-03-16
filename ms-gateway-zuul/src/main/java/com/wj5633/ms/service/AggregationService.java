package com.wj5633.ms.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wj5633.common.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;


/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/16 0:28
 * @description
 */

@Service
public class AggregationService {

    private final RestTemplate restTemplate;

    @Autowired
    public AggregationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserById(Long id) {

        return Observable.create(observer -> {
                    User user = restTemplate.getForObject("http://ms-provider/user/{id}", User.class, id);
                    observer.onNext(user);
                    observer.onCompleted();
                }
        );
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getMovieUserByUserId(Long id) {
        return Observable.create(observer -> {
            User movieUser = restTemplate.getForObject("http://ms-consumer/user/{id}", User.class, id);
            observer.onNext(movieUser);
            observer.onCompleted();
        });
    }

    public User fallback(Long id) {
        User user = new User();
        user.setId(-1L);
        return user;
    }
}
