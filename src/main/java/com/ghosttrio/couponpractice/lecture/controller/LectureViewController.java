package com.ghosttrio.couponpractice.lecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LectureViewController {

    @GetMapping("/lecture")
    public String loadLecturePage() {
        return "lecture";
    }
}
