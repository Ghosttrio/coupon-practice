package com.ghosttrio.couponpractice;

import com.ghosttrio.couponpractice.blog.TestEntity;
import com.ghosttrio.couponpractice.blog.TestRepository;
import com.ghosttrio.couponpractice.ticket.entity.CouponEntity;
import com.ghosttrio.couponpractice.ticket.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class CouponPracticeApplication implements ApplicationRunner {

    private final CouponRepository couponRepository;
    private final TestRepository testRepository;

    public static void main(String[] args) {
        SpringApplication.run(CouponPracticeApplication.class, args);
    }

    @Transactional
    @Override
    public void run(ApplicationArguments args) {
        CouponEntity coupon = CouponEntity.create("남은 티켓 수", 100L);
        couponRepository.save(coupon);
        TestEntity entity = TestEntity.create("테스트", 1000L);
        testRepository.save(entity);
    }

}
