package de.ait.car_service.service;

import de.ait.car_service.entity.Car;
import de.ait.car_service.repository.CarRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

  private final CarRepository repository;

  @Override
  public List<Car> getAllCars() {
    return repository.findAll();
  }

  @Override
  public List<Car> getCarsByBrand(String brand) {
    return getAllCars()
        .stream()
        .filter(car -> car.getBrand().equalsIgnoreCase(brand))
        .toList();
  }

  @Override
  public Car getCarById(Long id) {
    return getAllCars()
        .stream()
        .filter(car -> car.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  @Override
  public Car saveCar(Car car) {
    return repository.save(car);
  }

  @Override
  public Car delete(Long id) {
    return repository.delete(id);
  }

  @Override
  public Car updateCar(Car car) {return repository.save(car);
  }
}
