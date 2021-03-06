package com.xiao9.user.facade.rest;

import com.xiao9.user.infrastruction.security.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Security;

@RestController
@RequestMapping("/api")
public class UserResource {

    @GetMapping("/hello")
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        throw new RuntimeException("ζζδΊ");
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello";
    }

    @GetMapping("/admin/hello")
    public String hello3() {
        return "hello";
    }
    @GetMapping("/user/hello")
    public String hello4() {
        return "hello";
    }
}

