package com.example.test03_cookie2.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/member/login")
    public String loginForm() {
        return "member/login";
    }

    @PostMapping("/member/login")
    public String login(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpServletResponse response) {
        if(id.equals("hello") && pwd.equals("1234")) {
            Cookie cookie = new Cookie("id", id); //쿠키생성
            //cookie.setMaxAge(60*3); //쿠키유지시간 (초단위) -> 설정이 없으면 쿠키는 웹브라우저를 닫을때까지 유지됨
            response.addCookie(cookie); //쿠키를 응답객체에 담기
            return "redirect:/";
        }
        return "member/login";
    }

    @GetMapping("/member/logout")
    public String logout(HttpServletResponse response) {
        //쿠키삭제 -> 쿠키유지시간을 0으로 설정해서 응답객체에 담아보낸다.
        Cookie cookie = new Cookie("id", null); //value는 의미없음
        cookie.setMaxAge(0); //쿠키유지시간을 0으로 설정
        response.addCookie(cookie);
        return "redirect:/";
    }
}
