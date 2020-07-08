package com.irs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class RootContorller {

    @RequestMapping("/")
    public String rootList() {
        return "/index.html";
    }
}
