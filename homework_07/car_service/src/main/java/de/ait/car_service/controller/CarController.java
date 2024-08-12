package de.ait.car_service.controller;

import de.ait.car_service.entity.Car;
import de.ait.car_service.service.CarService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarController {

  private final CarService service;

    @GetMapping("/api/cars")
  public List<Car> getAllCars() {
    return service.getAllCars();
  }
  @GetMapping("/api/cars/{id}")
  public Car getCarById(@PathVariable Long id) {
    return service.getCarById(id);
  }

  @GetMapping("/api/cars")
  public List<Car> getCarsByBrand(@RequestParam(name = "brand", required = false) String brand) {
    if (brand.equals("")) {
      return service.getAllCars();
    } else {
      return service.getCarsByBrand(brand);
    }
  }
}
