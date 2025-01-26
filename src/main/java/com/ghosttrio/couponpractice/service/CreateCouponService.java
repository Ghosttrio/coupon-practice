package com.ghosttrio.couponpractice.service;

import com.ghosttrio.couponpractice.entity.CouponEntity;
import com.ghosttrio.couponpractice.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCouponService {

    private final CouponRepository couponRepository;

    @Transactional
    public void createCoupon(String name, Long quantity) {
        CouponEntity coupon = CouponEntity.create(name, quantity);
        couponRepository.save(coupon);
    }
}
