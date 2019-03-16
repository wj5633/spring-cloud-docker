package com.wj5633.ms.controller;

import com.google.common.collect.Maps;
import com.wj5633.common.vo.User;
import com.wj5633.ms.service.AggregationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/16 0:39
 * @description
 */

@Slf4j
@RestController
public class AggregationController {

    private final AggregationService aggregationService;

    @Autowired
    public AggregationController(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @GetMapping("/aggregate/{id}")
    public DeferredResult<HashMap<String, User>> aggregate(@PathVariable Long id) {
        Observable<HashMap<String, User>> result = aggregateObservable(id);
        return toDeferredResult(result);
    }

    private DeferredResult<HashMap<String, User>> toDeferredResult(Observable<HashMap<String, User>> details) {
        DeferredResult<HashMap<String, User>> result = new DeferredResult<>();
        details.subscribe(new Observer<HashMap<String, User>>() {
            @Override
            public void onCompleted() {
                log.info("完成...");
            }

            @Override
            public void onError(Throwable e) {
                log.info("发生错误..., {}", e);
            }

            @Override
            public void onNext(HashMap<String, User> stringUserHashMap) {
                result.setResult(stringUserHashMap);
            }
        });
           return result;
    }

    private Observable<HashMap<String, User>> aggregateObservable(Long id) {
        return Observable.zip(
                aggregationService.getUserById(id),
                aggregationService.getMovieUserByUserId(id),
                (user, movieUser) -> {
                    HashMap<String, User> map = Maps.newHashMap();
                    map.put("user", user);
                    map.put("movieUser", movieUser);
                    return map;
                }
        );
    }
}
