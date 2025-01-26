package com.ghosttrio.couponpractice.controller;

import com.ghosttrio.couponpractice.service.ConsumeCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupons")
@RequiredArgsConstructor
public class ConsumeCouponController {

    private final ConsumeCouponService consumeCouponService;

    @PatchMapping
    public void consumeCoupon() {
        consumeCouponService.consume();
    }

    // 단순 스레드 생성 후 요청
    // 결과 : 동시성 이슈 발생
    @PatchMapping("/basic/{count}")
    public Long basicConsumeCouponCount(@PathVariable Long count) throws InterruptedException {

        Runnable runnable = () -> {
            for (int i = 0; i < count; i++) {
                consumeCouponService.consume();
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        return consumeCouponService.getCouponRemain();
    }

    @PatchMapping("/sync/{count}")
    public Long syncConsumeCouponCount(@PathVariable Long count) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < count; i++) {
                consumeCouponService.consumeWithSync();
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        return consumeCouponService.getCouponRemainSync();

    }

    static class SleepUtil {
        public static void sleep(int ms) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
