package com.example.Practice.thirdOctober.reactiveProgramming;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.junit.jupiter.api.*;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

import java.util.Arrays;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<String> stringMono = Mono.just("Piyush").log();
        stringMono.subscribe(System.out::println);

        Mono<String> mono = Mono.just("efoijfoie").log();

        mono.subscribe(System.out::println);
    }

    @Test
    public void combineMono(){
        Mono<String> sm1 = Mono.just("Piyush");
        Mono<String> sm2 = Mono.just("Jogi");
        Mono<Integer> sm3 = Mono.just(12345);

        Mono.zip(sm1,sm2).subscribe(System.out::println);
        Mono<Tuple2<String, String>> tuple2Mono = sm1.zipWith(sm2);

        Mono<Tuple3<String, String, Integer>> combinedZip = Mono.zip(sm1, sm2, sm3);

        combinedZip.subscribe(d -> { System.out.println(d.getT1());
            System.out.println((d.getT2()));
            System.out.println(d.getT3());}
        );
        System.out.println(tuple2Mono);
    }

    @Test
    public void mapDemo(){
        Mono<String> sm1 = Mono.just("Piyush");
        Mono<String> sm2 = Mono.just("Jogi");

        Mono<String> resultMap = sm1.map(String::toUpperCase);

        resultMap.subscribe(System.out::println);

        // flatMap: use it when transformation returns another Publisher (Mono/Flux) example
        Mono<String[]> resultFlatMap = sm1.flatMap(val -> Mono.just(val.split("")));

        // Subscribe and print each letter
        resultFlatMap.subscribe(arr -> Arrays.stream(arr).forEach(System.out::println));

        //flatmap many example
        Flux<String> stringFlux = sm2.flatMapMany(val -> Flux.just(val.split("")));

        stringFlux.subscribe(System.out::println);
    }

    @Test
    public void testExceptionMono(){
        Mono<?> stringMono = Mono.just("Piyush")
                .then(Mono.error(new RuntimeException("EXCEPTION OCCURED")))
                .log();

        stringMono.subscribe(System.out::println,e-> System.out.println(e.getMessage()));
    }

    @Test
    public void testWebFlux(){
        Flux<String> stringFlux = Flux.just("Spring","Spring boot","Hibernate","Microservice")
                .concatWithValues("AWS")
                .log();

        stringFlux.subscribe(System.out::println);
    }

}
