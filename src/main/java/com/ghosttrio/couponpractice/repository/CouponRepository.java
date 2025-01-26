package com.ghosttrio.couponpractice.repository;

import com.ghosttrio.couponpractice.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
}
