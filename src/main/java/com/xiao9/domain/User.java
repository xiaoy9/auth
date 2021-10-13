package com.xiao9.domain;

import lombok.Data;

@Data
public class User {

    private Long id;

    // 登录名称
    private String login;

    // 邮箱
    private String email;

}
