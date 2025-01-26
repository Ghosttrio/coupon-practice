package com.ghosttrio.couponpractice.controller;


import com.ghosttrio.couponpractice.controller.model.request.CreateCouponRequest.Init;
import com.ghosttrio.couponpractice.service.CreateCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupons")
@RequiredArgsConstructor
public class CreateCouponController {

    private final CreateCouponService createCouponService;

    @PostMapping
    public ResponseEntity<String> setInitialCouponQuantity(@RequestBody Init request) {
        createCouponService.createCoupon(request.name(), request.quantity());
        return ResponseEntity.ok("쿠폰 생성에 성공했습니다.");
    }
}
