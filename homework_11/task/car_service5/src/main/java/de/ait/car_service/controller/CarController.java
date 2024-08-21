package de.ait.car_service.controller;

import de.ait.car_service.DTO.CarCreateDTO;
import de.ait.car_service.DTO.CarResponseDTO;
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

  @GetMapping("/cars/{id}")
  public CarResponseDTO getCarById(@PathVariable Long id) {
    return service.getCarById(id);
  }

  @GetMapping("/cars")
  public List<CarResponseDTO> getCarsByBrand(
      @RequestParam(name = "brand", required = false) String brand) {
    if (brand == null || brand.isEmpty()) {
      return service.getAllCars();
    } else {
      return service.getCarsByBrand(brand);
    }
  }

  @PostMapping("/cars")
  public CarResponseDTO addCar(@RequestBody CarCreateDTO car) {
    return service.create(car);
  }

  @DeleteMapping("/cars/{id}")
  public CarResponseDTO deleteCar(@PathVariable Long id) {
    return service.delete(id);
  }

  @PutMapping("/cars/{id}")
  public CarResponseDTO updateCar(@PathVariable Long id, @RequestBody CarCreateDTO carCreateDTO) {
    return service.updateCar(id, carCreateDTO);
  }
}
