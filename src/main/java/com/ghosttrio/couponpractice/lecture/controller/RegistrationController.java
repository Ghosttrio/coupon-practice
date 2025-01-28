package com.ghosttrio.couponpractice.lecture.controller;

import com.ghosttrio.couponpractice.lecture.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping("/tryEnter")
    public String tryEnter(Model model) {
        String message = registrationService.tryEnter();
        model.addAttribute("message", message);
        model.addAttribute("currentCapacity", registrationService.getCurrentCapacity());
        model.addAttribute("waitingQueueSize", registrationService.getWaitingQueueSize());
        return "registration";  // 타임리프 템플릿 파일
    }

    @GetMapping("/leave")
    public String leave(Model model) {
        registrationService.leave();
        model.addAttribute("message", "나갔습니다.");
        model.addAttribute("currentCapacity", registrationService.getCurrentCapacity());
        model.addAttribute("waitingQueueSize", registrationService.getWaitingQueueSize());
        return "registration";  // 타임리프 템플릿 파일
    }

}
