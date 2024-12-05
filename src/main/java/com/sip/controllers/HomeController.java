package com.sip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @RequestMapping(value={"/","hom**"})// tous ce qui commence par hom
    public String home() {
        return "front/index"; //automatiquement sous templates
    }

    public String login() {
        return "";
    }

    public String registration() {
        return "";
    }

    public String forgotPassword() {
        return "";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "front/contact";
    }
}
