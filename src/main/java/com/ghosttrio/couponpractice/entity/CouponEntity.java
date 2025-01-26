package com.ghosttrio.couponpractice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CouponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long quantity;

    public static CouponEntity create(String name, Long quantity) {
        return new CouponEntity(null, name, quantity);
    }

    public Long consume() {
        System.out.println("쿠폰 발급 스레드 : " + Thread.currentThread().getName());
        return this.quantity--;
    }
    public synchronized Long consumeSync() {
        System.out.println("쿠폰 발급 스레드 : " + Thread.currentThread().getName());
        return this.quantity--;
    }
}
