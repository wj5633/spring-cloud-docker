package com.wj5633.provider.service;

import com.wj5633.common.vo.UserResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/12 2:07
 * @description
 */

public interface IUserService {

    UserResponse findById(Long id);
}
