package com.ghosttrio.couponpractice.ticket.repository;

import com.ghosttrio.couponpractice.ticket.entity.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<ParticipantEntity, Long> {
}
