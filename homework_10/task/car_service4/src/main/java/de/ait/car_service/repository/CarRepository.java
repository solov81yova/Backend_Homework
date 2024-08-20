package de.ait.car_service.repository;

import de.ait.car_service.entity.Car;
import java.util.List;

public interface CarRepository {

  List<Car> getAllCars();

  List<Car> findAll();

  Car findById(Long id);

  Car save(Car car);

  Car delete(Long id);
}
