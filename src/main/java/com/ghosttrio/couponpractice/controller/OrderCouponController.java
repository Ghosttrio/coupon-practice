package com.ghosttrio.couponpractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.ghosttrio.couponpractice.controller.ConsumeCouponController.SleepUtil.sleep;

@RestController
@RequestMapping("/coupons")
public class OrderCouponController {

    private final ExecutorService executorService = Executors.newFixedThreadPool(1000);
    private Long remainCouponQuantity = 100_000L;
    private final Lock lock = new ReentrantLock();

    @GetMapping("/order/{count}")
    public void executeOrderCouponService(@PathVariable Long count) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                lock.lock();
                if (remainCouponQuantity == 0) {
                    System.out.println(Thread.currentThread().getName() + " 님 죄송합니다! 남은 쿠폰이 없습니다.");
                } else {
                    System.out.println(Thread.currentThread().getName() + " 님 축하드립니다! 쿠폰 발급이 성공했습니다.");
                    remainCouponQuantity--;
                }
            } finally {
                lock.unlock();
                System.out.println("남은 쿠폰 수: " + remainCouponQuantity);
            }
        };

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        sleep(3000);
        for (Thread thread : threads) {
            thread.join();
        }

    }

}
