package com.webflux.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/")
@Slf4j
public class InitialResource {

    @Autowired
    private AsyncClass asyncClass;

    @GetMapping
    @RequestMapping("/")
    public String init() {
        String str = "Welcome to Spring WebFlux Netty Application";
        System.out.println(str);
        return str;
    }

    /* Reactive Programming Non Blocking IO*/
    @GetMapping
    @RequestMapping("/monoDelay")
    public String monoDelayed() {
        log.info(" [Mono Start]");
        Mono<String> stringMono = Mono.defer(() -> Mono.just(Thread.currentThread() + "  Mono Delay Result is ready!"))
                .delaySubscription(Duration.ofMillis(5000));
        stringMono.subscribe(System.out::println);
        log.info(" [Mono End]");
        return "Sync Result";
    }

    /* Regular Programming Blocking IO*/
    @GetMapping
    @RequestMapping("/regularDelay")
    public String regularDelay() throws InterruptedException {
        log.info(" [Regular Start]");
        Thread.sleep(5000);
        log.info(" [Regular End]");
        return "Regular Delay Result is ready!";
    }

    @GetMapping
    @RequestMapping("/regularAsyncDelay")
    public String regularAsyncDelay() throws InterruptedException {
        log.info(Thread.currentThread() + " [Regular Start]");
        asyncClass.asyncMethod();
        log.info(Thread.currentThread() + " [Regular End]");
        return "Regular Async Delay Result is ready!";
    }
}
