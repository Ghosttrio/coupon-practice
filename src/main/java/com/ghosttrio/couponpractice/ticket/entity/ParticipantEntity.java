package com.ghosttrio.couponpractice.ticket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ParticipantEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String user;
    private Boolean isSuccess;

    public static ParticipantEntity create(String user, Boolean isSuccess) {
        return new ParticipantEntity(null, user, isSuccess);
    }
}
