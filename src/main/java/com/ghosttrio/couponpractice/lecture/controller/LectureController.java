package com.ghosttrio.couponpractice.lecture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LectureController {

    @GetMapping("/api/lecture")
    public void entrance() {

    }
}

