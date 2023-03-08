package com.kgisl.webfluxRH.controller;

import com.kgisl.webfluxRH.service.CarServiceImpl;
import com.kgisl.webfluxRH.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @GetMapping("/")
    public Flux<Car> getAllCars() {
        System.out.println("Found All Cars");
        return carService.loadAllCars();
    }

    @GetMapping("/{id}")
    public Mono<Car> getCarById(@RequestBody Car car, @PathVariable("id") Integer id) {
        System.out.println("Car Id "+ id +" Found");
        return carService.findById(id);
    }

    @PostMapping("/post")
    public Mono<Car> create(@RequestBody Car car) {
        System.out.println("New Car Created");
        return carService.create(car);
    }

    @PutMapping("update/{id}")
    public Mono<ResponseEntity<Car>> updateCarById(@PathVariable Integer id,
            @RequestBody Mono<Car> car) {
                System.out.println("Car Id " + id + " Updated");
        return carService.update(car, id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteCarById(@PathVariable Integer id) {
        System.out.println("Car Id " + id +" Deleted Successfully");
        return carService.delete(id)
                .map(r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.ok().build());
    }
}
