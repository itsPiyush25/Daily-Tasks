package com.example.Practice.eighthOct;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;

public class MonoFluxPractice {
    public static void main(String[] args) {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();


        Mono<String> stringMono = Mono.just("Hello");

        Flux<String> flux1 = stringMono.flatMapMany(d -> Flux.just(d.split("")));

        Mono<String> next = flux1.next();

        next.subscribe(System.out::println);

        System.out.println("------------------------------------");

        Mono<String> last = flux1.last();

        last.subscribe(System.out::println);

        System.out.println("------------------------------------");

        flux1.subscribe(System.out::println);

        //map() transforms each element synchronously.

        Flux<String> fruitFlux = Flux.just("apple", "mango", "lemon")
                .map(String::toUpperCase);

        Flux<Integer> map = fruitFlux.map(String::length);

        fruitFlux.subscribe(System.out::println);

        map.subscribe(System.out::println);

        //flatMapMany() is used with Mono to transform it into a Flux.

        System.out.println("------------------------------------");

        Mono<String> word = Mono.just("spring");
        Flux<String> chars = word.flatMapMany(w ->
                Flux.fromArray(w.split("")));

        chars.subscribe(System.out::println);

        System.out.println("------------------------------------");

        // flatMap - order not guaranteed (parallel)
        Flux.just(1, 2, 3)
                .flatMap(i -> Mono.just(i)
                        .delayElement(Duration.ofMillis(100 - i * 10)))
                .subscribe(System.out::println);

        // Output might be: 3, 2, 1 (reversed!)
    }
}