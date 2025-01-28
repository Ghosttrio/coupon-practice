package com.ghosttrio.couponpractice.ticket.entity;

import jakarta.persistence.*;
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

    public void consume() {
        this.quantity--;
    }
}
