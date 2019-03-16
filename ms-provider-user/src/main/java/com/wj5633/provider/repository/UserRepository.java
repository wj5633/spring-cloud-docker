package com.wj5633.provider.repository;

import com.wj5633.provider.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/10 12:41
 * @description
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
