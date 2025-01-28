package com.ghosttrio.couponpractice.ticket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@RequiredArgsConstructor
public class LockService {

    private final ConsumeTicketService consumeTicketService;
    private final Lock lock = new ReentrantLock(true);

    public boolean support(String user) {
        lock.lock();
        try {
            boolean result = consumeTicketService.process();
            consumeTicketService.createParticipantUser(user, result);
            return result;
        } finally {
            lock.unlock();
        }
    }
}
