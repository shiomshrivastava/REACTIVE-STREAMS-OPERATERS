package com.reactive.demo;

import reactor.core.publisher.Flux;

public class OperatorsDemo {

    public static void main(String[] args) {

        System.out.println("=== Reactive Stream Operators Demo ===\n");

        // MAP Operator
        System.out.println("\n MAP Operator:");
        Flux.just(1, 2, 3, 4)
            .map(i -> i * i)
            .subscribe(i -> System.out.println("Mapped value: " + i));

        // FILTER Operator
        System.out.println("\n FILTER Operator:");
        Flux.range(1, 10)
            .filter(i -> i % 2 == 0)
            .subscribe(i -> System.out.println("Filtered value: " + i));

        // FLATMAP Operator
        System.out.println("\n FLATMAP Operator:");
        Flux.just("Shiom", "Trisha")
            .flatMap(name -> Flux.fromArray(name.split("")))
            .subscribe(ch -> System.out.print(ch + " "));
        System.out.println();

        // REDUCE Operator
        System.out.println("\n REDUCE Operator:");
        Flux.range(1, 5)
            .reduce((a, b) -> a + b)
            .subscribe(sum -> System.out.println("Sum = " + sum));

        // MERGE Operator
        System.out.println("\n MERGE Operator:");
        Flux<String> flux1 = Flux.just("A", "B", "C");
        Flux<String> flux2 = Flux.just("1", "2", "3");
        Flux.merge(flux1, flux2)
            .subscribe(item -> System.out.println("Merged item: " + item));

        // ZIP Operator
        System.out.println("\n ZIP Operator:");
        Flux<String> names = Flux.just("Somya", "Muskan", "Pulkit");
        Flux<Integer> ages = Flux.just(22, 23, 21);
        Flux.zip(names, ages, (n, a) -> n + " is " + a + " years old")
            .subscribe(System.out::println);

        // CONCAT Operator
        System.out.println("\n CONCAT Operator:");
        Flux.concat(
                Flux.just("Start"),
                Flux.just("Middle"),
                Flux.just("End"))
            .subscribe(System.out::println);

        System.out.println("\n All operators demonstrated successfully!");
    }
}
