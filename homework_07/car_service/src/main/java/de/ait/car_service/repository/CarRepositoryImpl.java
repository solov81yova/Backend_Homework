package de.ait.car_service.repository;

import de.ait.car_service.entity.Car;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepositoryImpl implements CarRepository {

  List<Car> cars = List.of(
      new Car(1L, "Toyota", "Camry", 2.5, 2021),
      new Car(2L, "BMW", "X5", 3.0, 2019),
      new Car(3L, "Audi", "A4", 2.0, 2020),
      new Car(4L, "Honda", "Civic", 1.5, 2022),
      new Car(5L, "BMW", "X5", 3.0, 2019)
  );

  @Override
  public List<Car> findAll() {
    return cars;
  }

  @Override
  public Car findById(Long id) {
    for (Car car : cars) {
      if (car.getId().equals(id)) {
        return car;
      }
    }
    return null;
  }

  @Override
  public Car save(Car car) {
    return null;
  }
}
