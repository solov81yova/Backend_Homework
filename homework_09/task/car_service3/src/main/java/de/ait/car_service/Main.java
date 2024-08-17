package de.ait.car_service;
/*
В проекте предыдущего ДЗ (про автомобили) реализуйте репозиторий на основе JDBC
Внимание, чтобы Spring не выдавал ошибку, в репозитории который используете сейчас,
уберите аннотацию Repository, а в классе JDBCRepositoryImpl наоборот, не забудьте поставить.

 */

import de.ait.car_service.entity.Car;
import de.ait.car_service.repository.JDBCRepositoryImpl;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    JDBCRepositoryImpl.loadDriver();
    List<Car> cars = JDBCRepositoryImpl.getAllCars();
    System.out.println(cars);

    Car car = new Car("Opel", "Corsa F", 1.5, 2022);
    Car car1 = JDBCRepositoryImpl.createCar(car);
    System.out.println(car1);
    System.out.println();
    cars = JDBCRepositoryImpl.getAllCars();
    System.out.println(cars);
  }

}
