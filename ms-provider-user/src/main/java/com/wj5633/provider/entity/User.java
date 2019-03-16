package com.wj5633.provider.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangjie
 * @version 1.0.0
 * @create 2019/3/10 12:39
 * @description
 */

@Entity
@Table(name = "ms_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;
}
