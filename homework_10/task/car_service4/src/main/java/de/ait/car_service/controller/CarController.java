package de.ait.car_service.controller;

import de.ait.car_service.entity.Car;
import de.ait.car_service.service.CarService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CarController {

  private final CarService service;

//  @GetMapping("/cars")
//  public List<Car> getAllCars() {
//    return service.getAllCars();
//  }

  @GetMapping("/cars/{id}")
  public Car getCarById(@PathVariable Long id) {
    return service.getCarById(id);
  }

  @GetMapping("/cars")
  public List<Car> getCarsByBrand(@RequestParam(name = "brand", required = false) String brand) {
    if (brand == null || brand.isEmpty()) {
      return service.getAllCars();
    } else {
      return service.getCarsByBrand(brand);
    }
  }

  @PostMapping("/cars")
  public Car addCar(@RequestBody Car car) {
    service.saveCar(car);
    return car;
  }

  @DeleteMapping("/cars")
  public Car deleteCar(@RequestBody Car car) {
    service.delete(car.getId());
    return car;
  }

  @PutMapping("/cars")
  public Car updateCar(@RequestBody Car car) {
    service.updateCar(car);
    return car;
  }
}
