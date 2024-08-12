package de.ait.car_service.service;

import de.ait.car_service.entity.Car;
import java.util.List;

public interface CarService {

  public List<Car> getAllCars();

  public List<Car> getCarsByBrand(String brand);

  public Car getCarById(Long id);

  public Car saveCar(Car car);
}
