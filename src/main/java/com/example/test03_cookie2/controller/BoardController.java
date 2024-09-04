package com.example.test03_cookie2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class BoardController {
    @GetMapping("/member/board")
    public String item(Model model) {
        ArrayList<String> list = new ArrayList<>();
        list.add("게시글1");
        list.add("게시글2");
        list.add("게시글3");
        model.addAttribute("list", list);
        return "member/board";

    }
}
