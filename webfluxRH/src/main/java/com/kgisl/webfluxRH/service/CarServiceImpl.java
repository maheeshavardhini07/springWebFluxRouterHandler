package com.kgisl.webfluxRH.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kgisl.webfluxRH.model.Car;
import com.kgisl.webfluxRH.repository.CarRepository;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    public CarRepository carRepo;

    @Override
    public Mono<Car> create(Car e) {
        return carRepo.save(e);
    }
    @Override
    public Flux<Car> loadAllCars() {
        return carRepo.findAll();
    }

    public Mono<Car> findById(Integer id) {
        return carRepo.findById(id);
    }

    public Mono<Void> delete(Integer id) {
        return carRepo.deleteById(id);
    }

    public Mono<Car> update(int carId) {
        return null;
    }
    @Override
    public Mono<Car> update(Mono<Car> e, Integer id) {
        return carRepo.save(e);
    }

}