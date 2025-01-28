package com.ghosttrio.couponpractice.ticket.controller;

import com.ghosttrio.couponpractice.ticket.controller.model.request.ConsumeRequest;
import com.ghosttrio.couponpractice.ticket.service.ConsumeTicketService;
import com.ghosttrio.couponpractice.ticket.service.LockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;


@RestController
@RequiredArgsConstructor
public class TicketController {

    private final LockService lockService;
    private final ConsumeTicketService consumeTicketService;
    private final ExecutorService executorService = Executors.newFixedThreadPool(1000);

    // 성능 : 10,000 요청 -> 3273ms ~ 3305ms
    @PostMapping("/api/ticket")
    public String consumeTicket(@RequestBody ConsumeRequest request) {
        executorService.submit(() -> lockService.support(request.user()));
        return "ok";
    }

    @GetMapping("/api/count")
    public String getCount() {
        return String.format("성공: %d, 실패: %d",
                consumeTicketService.getSuccessCount().get(),
                consumeTicketService.getFailureCount().get());
    }

}
