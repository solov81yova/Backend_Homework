package de.ait.car_service.repository;

import de.ait.car_service.entity.Car;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepositoryImpl implements CarRepository {

  private List<Car> cars = new ArrayList<>(List.of(
      new Car(1L, "Toyota", "Camry", 2.5, 2021),
      new Car(2L, "BMW", "X5", 3.0, 2019),
      new Car(3L, "Audi", "A4", 2.0, 2020),
      new Car(4L, "Honda", "Civic", 1.5, 2022),
      new Car(5L, "BMW", "X5", 3.0, 2019)
  ));

  @Override
  public List<Car> getAllCars() {
    return cars;
  }

  @Override
  public List<Car> findAll() {
    return new ArrayList<>(cars);
  }

  @Override
  public Car save(Car entity) {
    if (entity.getId() == null) {
      return create(entity);
    } else {
      return update(entity);
    }
  }

  private Car create(Car entity) {
    long max = cars.stream().mapToLong(car -> car.getId().longValue())
        .max().getAsLong();
    entity.setId(++max);
    cars.add(entity);
    return entity;
  }

  private Car update(Car entity) {
    Car car = cars.stream()
        .filter(c -> c.getId().equals(entity.getId()))
        .findAny()
        .orElse(null);

    if (car != null) {
      car.setBrand(entity.getBrand());
      car.setModel(entity.getModel());
      car.setEngineVolume(entity.getEngineVolume());
      car.setYear(entity.getYear());
    }
    return car;
  }

  @Override
  public Car findById(Long id) {
    return cars.stream()
        .filter(car -> car.getId() == id)
        .findFirst()
        .orElse(null);
  }

  @Override
  public Car deleteById(Long id) {
    return cars.stream()
        .filter(car -> car.getId().equals(id))
        .findFirst()
        .map(car -> {
          cars.remove(car);
          return car;
        })
        .orElse(null);
  }
}
