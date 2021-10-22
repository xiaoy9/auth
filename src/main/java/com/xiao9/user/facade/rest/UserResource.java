package com.xiao9.user.facade.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResource {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
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
