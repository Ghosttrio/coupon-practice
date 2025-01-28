package com.ghosttrio.couponpractice.lecture.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Service
public class LectureService {
    private static final int 입장방_최대수 = 100; // 정원
    private static final int 대기방_최대수 = 1000; // 대기 최대
    private final BlockingQueue<Integer> 입장방 = new ArrayBlockingQueue<>(입장방_최대수, true); //
    private final BlockingQueue<Integer> 대기방 = new ArrayBlockingQueue<>(대기방_최대수, true); // 대기방

    // 입장
    public String entrance(Integer number) throws InterruptedException {
        if (대기방.size() >= 대기방_최대수) return number + " 유저 - 대기방 인원이 초과되었습니다. 입장할 수 없습니다.";
        if (입장방.size() >= 입장방_최대수) {
            // 대기
            대기방.put(number);
            return number + " 유저가 대기방에서 대기합니다.";
        } else {
            입장방.put(number);
            return number + " 유저가 입장에 성공했습니다.";
        }
    }

    // 0번 유저가 나간다고 가정
    public void out() {
        try {
            Integer take = 입장방.take();
            System.out.println(take + "번 유저가 퇴장했습니다.");
            if (!대기방.isEmpty()) {
                Integer 대기방_유저 = 대기방.take();
                입장방.put(대기방_유저);
                System.out.println(대기방_유저 + " 유저가 입장에 성공했습니다.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void list() {
        boolean a = 입장방.contains(0);
        boolean b = 입장방.contains(100);
        boolean c = 대기방.contains(100);
        System.out.println(입장방.size());
    }

}
