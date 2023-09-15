package com.webflux.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

@SpringBootTest
class SpringWebFluxNettyApplicationTests {

    @Test
    void testMono() {
        Mono<String> mono = Mono.just("Reactive programming");
        mono.subscribe(System.out::println);

        mono = Mono.just("Reactive programming with log").log();
        mono.subscribe(System.out::println);
    }

    @Test
    void testMono1() {
        Mono<?> mono = Mono.just("Reactive programming").then(Mono.error(new RuntimeException("Exception Occurred")));
        mono.subscribe(System.out::println);

		System.out.println("-------------------");

        mono = Mono.just("Reactive programming With log").then(Mono.error(new RuntimeException("Exception Occurred"))).log();
        mono.subscribe(System.out::println, throwable -> System.out.println(throwable));
    }

	@Test
	void testFlux() {
		Flux<String> flux = Flux.just("One", "Two", "Three", "Five", "Four");
		flux.subscribe(System.out::println);
	}
}
