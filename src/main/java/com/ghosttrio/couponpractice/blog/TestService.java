package com.ghosttrio.couponpractice.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;
    private static final Long TEST_ID = 1L;

    @Component
    @RequiredArgsConstructor
    static class ExecuteProxy {

        private final TestService testService;
        private final Lock lock = new ReentrantLock(true);

        public void execute() {
            lock.lock();
            try {
                testService.process();
            } finally {
                lock.unlock();
            }
        }
    }

    @Transactional
    public void process() {
        TestEntity entity = testRepository.findById(TEST_ID)
                .orElseThrow(RuntimeException::new);
        if (entity.getQuantity() == 0) return;
        entity.consume();
    }
}
