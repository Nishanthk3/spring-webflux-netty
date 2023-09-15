package com.webflux.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncClass {

    @Async
    public void asyncMethod() throws InterruptedException {
        log.info(Thread.currentThread() + " [AsyncMethod Start]");
        Thread.sleep(5000);
        log.info(Thread.currentThread() + " [AsyncMethod End]");
    }
}
