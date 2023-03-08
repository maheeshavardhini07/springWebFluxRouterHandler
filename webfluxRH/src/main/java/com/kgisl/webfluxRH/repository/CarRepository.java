package com.kgisl.webfluxRH.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.kgisl.webfluxRH.model.Car;

import reactor.core.publisher.Mono;

public interface CarRepository extends ReactiveCrudRepository<Car, Integer> {

    Mono<Car> findById(Integer id);

    Mono<Void> deleteById(Integer id);

    Mono<Car> save(Mono<Car> cMono);

}
