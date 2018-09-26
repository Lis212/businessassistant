package io.khasang.ba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping("/")
    public String getHelloPage(Model model){
        model.addAttribute("name", "first Spring application!");
        return "home";
    }
}
