package com.wj5633.provider.service.impl;

import com.wj5633.common.vo.User;
import com.wj5633.provider.repository.UserRepository;
import com.wj5633.provider.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/12 2:08
 * @description
 */

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User findById(Long id) {
        com.wj5633.provider.entity.User user = userRepository.getOne(id);
        if (user == null) {
            throw new RuntimeException("not found!");
        }

        return new User(user.getId(), user.getUsername(), user.getName(), user.getAge(), user.getBalance());
    }
}
