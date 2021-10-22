package com.xiao9.user.domain;

import com.xiao9.user.infrastruction.po.RolePO;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class User {

    // 用户id
    private Long id;

    // 登录名
    private String login;

    // 密码
    private String password;

    // 邮箱
    private String email;

    // 激活标志
    private boolean activated = false;

    // 用户头像
    private String imageUrl;

    // 用户角色
    private Set<RolePO> roles;

    // 用户激活码
    private String activationKey;

    // 密码重置码
    private String resetKey;

    // 重置日期
    private Instant resetDate = null;

    // 创建日期
    private LocalDateTime createdDate;
}
