package com.ghosttrio.couponpractice.ticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/main")
    public String loadView() {
        return "ticket";
    }
}
