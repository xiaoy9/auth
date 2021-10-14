package com.xiao9.facade.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @GetMapping("/api/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello")
    public String hello2() {
        return "hello";
    }

    @GetMapping("/api/admin/hello")
    public String hello3() {
        return "hello";
    }

    @GetMapping("/api/user/hello")
    public String hello4() {
        return "hello";
    }
}
