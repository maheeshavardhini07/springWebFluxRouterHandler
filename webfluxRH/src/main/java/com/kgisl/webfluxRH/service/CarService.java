package com.kgisl.webfluxRH.service;

import com.kgisl.webfluxRH.model.Car;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarService {

    Mono<Car> create(Car e);

    Mono<Car> findById(Integer id);

    Flux<Car> loadAllCars();

    Mono<Car> update(Mono<Car> e, Integer id);

    Mono<Void> delete(Integer id);
    
}

