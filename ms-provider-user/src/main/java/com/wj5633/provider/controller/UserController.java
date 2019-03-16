package com.wj5633.provider.controller;

import com.alibaba.fastjson.JSON;
import com.wj5633.common.vo.UserResponse;
import com.wj5633.provider.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/10 12:42
 * @description
 */

@RestController
@Slf4j
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public UserResponse findById(@PathVariable Long id) {
        /*Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                log.info("当前用户是：{}， 角色是：{}", user.getUsername(), authority);
            }
        } else {
            log.info("......");
        }*/

        UserResponse user = userService.findById(id);
        log.info("UserController:findById -> {}", JSON.toJSONString(user));
        return user;
    }
}
