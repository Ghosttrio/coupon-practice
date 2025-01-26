package com.ghosttrio.couponpractice.controller.model.request;

public class CreateCouponRequest {

    public record Init(
            String name,
            Long quantity
    ) {
    }
}
