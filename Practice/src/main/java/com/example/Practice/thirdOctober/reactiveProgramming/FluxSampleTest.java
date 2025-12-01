//package com.example.Practice.thirdOctober.reactiveProgramming;
//
////import org.junit.jupiter.api.Test;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
////import reactor.core.publisher.Flux;
//
//import java.util.function.Function;
//
//@FunctionalSpringBootTest
//public class FluxSampleTest {
//
//    @Autowired
//    private FluxSampleService fluxSampleService;
//
//    Flux<String> stringFlux = Flux.just("piyush","jogi","Neosoft");
//
//    @Test
//    public void simpleFluxToast(){
//        fluxSampleService.getFlux().subscribe(data -> {
//            System.out.println(data);
//            System.out.println("DONE WITH FLUX DATA...");
//        });
//    }
//
//    @Test
//    public void getFruitFluxList(){
////        fluxSampleService.fruitFlux().subscribe(data -> {
////            System.out.println(data);
////            System.out.println("DONE WITH FLUX DATA...");
////        });
//        Flux<String> stringFlux1 = fluxSampleService.fruitFlux();
////        stringFlux1.doOnNext();
//        fluxSampleService.fruitFlux().subscribe(System.out::println);
//    }
//
//    @Test
//    public void getFluxData(){
//        stringFlux.subscribe(System.out::println);
//        String s = stringFlux.blockFirst();
//        System.out.println(s);
//    }
//
//    @Test
//    public void getMapData(){
//        fluxSampleService.mapExampleFlux().subscribe(System.out::println);
//    }
//
//    @Test
//    public void mapTest() {
//        Flux<String> capFlux = fluxSampleService.mapExampleFlux();
//    }
//
//    // filter
//    @Test
//    public void filterExampleFlux(){
//        Flux<String> flux = fluxSampleService.getFlux().filter(nav -> nav.length() > 4).log();
//
//        System.out.println(flux);
//    }
//
//    @Test
//    public void flatMapFluxExample(){
//        Flux<String> flatMapExample = fluxSampleService.flatMapExample();
//
//    }
//
//}
