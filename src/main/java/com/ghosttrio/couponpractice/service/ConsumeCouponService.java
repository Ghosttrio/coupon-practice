package com.ghosttrio.couponpractice.service;

import com.ghosttrio.couponpractice.entity.CouponEntity;
import com.ghosttrio.couponpractice.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConsumeCouponService {

    private final CouponRepository couponRepository;
    private Long remainCouponQuantity = 1_000_000L;

    public void consume() {
        String name = Thread.currentThread().getName();
        System.out.println("메서드 진입 스레드 : " + name);
        remainCouponQuantity = remainCouponQuantity - 1;
    }
    public Long getCouponRemain() {
        return remainCouponQuantity;
    }

    public synchronized void consumeWithSync() {
        String name = Thread.currentThread().getName();
        System.out.println("메서드 진입 스레드 : " + name);
        remainCouponQuantity = remainCouponQuantity - 1;
    }
    public synchronized Long getCouponRemainSync() {
        return remainCouponQuantity;
    }

}
