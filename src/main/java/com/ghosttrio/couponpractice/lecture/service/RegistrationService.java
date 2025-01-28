package com.ghosttrio.couponpractice.lecture.service;


import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RegistrationService {

    private static final int MAX_CAPACITY = 3;  // 한 번에 입장 가능한 인원
    private AtomicInteger currentCapacity = new AtomicInteger(0); // 현재 입장한 인원 수
    private AtomicInteger waitingQueue = new AtomicInteger(1); // 대기순번 관리

    // 입장 가능 여부 확인
    public synchronized String tryEnter() {
        if (currentCapacity.get() < MAX_CAPACITY) {
            currentCapacity.incrementAndGet();  // 입장
            return "입장 성공!"; // 입장한 경우
        } else {
            int position = waitingQueue.getAndIncrement(); // 대기 순번
            return "대기 중... 대기 순번: " + position; // 대기 중인 경우
        }
    }

    // 나가면 빈자리 처리
    public synchronized void leave() {
        if (currentCapacity.get() > 0) {
            currentCapacity.decrementAndGet(); // 나가면 입장 인원 감소
        }
    }

    public int getCurrentCapacity() {
        return currentCapacity.get();
    }

    public int getWaitingQueueSize() {
        return waitingQueue.get() - 1;  // 대기 순번은 1부터 시작하므로
    }
}
