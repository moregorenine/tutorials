package com.moregore.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping(value = "/")
    public String index() {
        return "home";
    }

    @GetMapping(value = "/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping(value = "/user")
    public String user() {
        return "user";
    }

    @GetMapping(value = "/admin/pay")
    public String adminPay() {
        return "adminPay";
    }

    @GetMapping(value = "/admin/**")
    public String admin() {
        return "admin";
    }
}
