package com.ghosttrio.couponpractice.ticket.service;

import com.ghosttrio.couponpractice.ticket.entity.CouponEntity;
import com.ghosttrio.couponpractice.ticket.entity.ParticipantEntity;
import com.ghosttrio.couponpractice.ticket.repository.CouponRepository;
import com.ghosttrio.couponpractice.ticket.repository.ParticipantRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;


@Getter
@Service
@RequiredArgsConstructor
public class ConsumeTicketService {

    private final CouponRepository couponRepository;
    private final ParticipantRepository participantRepository;
    private final AtomicInteger successCount = new AtomicInteger(0);
    private final AtomicInteger failureCount = new AtomicInteger(0);

    @Transactional
    public boolean process() {
        CouponEntity coupon = loadCouponEntity();
        if (coupon.getQuantity() <= 0) {
            failureCount.incrementAndGet();
            return false;
        }
        coupon.consume();
        successCount.incrementAndGet();
        return true;
    }

    @Transactional
    public void createParticipantUser(String user, Boolean isSuccess) {
        ParticipantEntity participant = ParticipantEntity.create(user, isSuccess);
        participantRepository.save(participant);
    }

    public CouponEntity loadCouponEntity() {
        return couponRepository.findById(1L)
                .orElseThrow(IllegalArgumentException::new);
    }

}
