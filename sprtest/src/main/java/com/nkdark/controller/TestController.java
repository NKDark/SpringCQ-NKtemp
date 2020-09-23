package com.nkdark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by Intellij IDEA
 *
 * @Author: NKDark
 * @Date: create in 2020/9/22 1:11
 * @Description:
 */

@Controller
@RequestMapping
public class TestController {
    @GetMapping("/m")
    public String hello(){
        return "redirect:/index.html";
    }
}
