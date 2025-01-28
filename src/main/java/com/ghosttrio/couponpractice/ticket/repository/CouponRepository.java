package com.ghosttrio.couponpractice.ticket.repository;

import com.ghosttrio.couponpractice.ticket.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
}
