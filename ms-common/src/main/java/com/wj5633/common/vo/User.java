package com.wj5633.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/12 2:32
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;

    private String username;

    private String name;

    private Integer age;

    private BigDecimal balance;
}
