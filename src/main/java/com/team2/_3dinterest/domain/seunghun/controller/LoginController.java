package com.team2._3dinterest.domain.seunghun.controller;


import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
    public String index() {
        return "로그인 화면 구현";
    }
    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }
}
