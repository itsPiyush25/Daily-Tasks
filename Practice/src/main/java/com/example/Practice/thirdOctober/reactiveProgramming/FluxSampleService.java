package com.example.Practice.thirdOctober.reactiveProgramming;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.util.List;

@Service
public class FluxSampleService{

    public Flux<String> getFlux(){
        return Flux.just("ak", "bk", "pj").log();
    }

    public Flux<String> fruitFlux(){
        return Flux.just("banana","apple","guava");
    }

    public Flux<Void> getBlankFlux(){
        return Flux.empty();
    }

    public Flux<String> mapExampleFlux(){

        return getFlux().map(String::toUpperCase);
    }

    //flatmap example

    public Flux<String> flatMapExample(){
//        return getFlux().flatMap(name -> Flux.just(name.split("")));
//        StepVerifier.create(capFlux)
//                .expectNext("PIYUSH", "JOGI") // adjust as per your transformation logic
//                .verifyComplete();

        return null;
    }




    public Flux<String> zipExample(){

        return Flux.zip(getFlux(),Flux.just(12,1,89),(first,second)->{
            return first+": "+second;
        });

    }







}
