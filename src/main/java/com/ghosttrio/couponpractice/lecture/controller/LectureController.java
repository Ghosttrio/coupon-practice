package com.ghosttrio.couponpractice.lecture.controller;

import com.ghosttrio.couponpractice.lecture.controller.model.request.LectureRequest;
import com.ghosttrio.couponpractice.lecture.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 100명 입장에 성공하고 나머지는 대기, 앞에 몇 명이 대기하는지 알 수 있다.
@RestController
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @PostMapping("/api/lecture")
    public String entrance(@RequestBody LectureRequest request) throws InterruptedException {
        return lectureService.entrance(request.user());
    }

    @PostMapping("/api/lecture/out")
    public String out() {
        lectureService.out();
        return "ok";
    }

    @GetMapping("/api/lecture/list")
    public String list() {
        return lectureService.list();
    }
}

