package de.ait.car_service;
/*
В вашем проекте автомобиле реализуйте полный набор операций с помощью JDBC репозитория.
Должны быть:
-вывод списка автомобилей,
-получение автомобиля по id,
-добавление нового автомобиля,
-изменение существующего автомобиля,
-удаление автомобиля,
-получения всех автомобилей данного бренда.
Pеализуйте необходимые методы в репозитории, kонтроллере и сервисе.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarServiceApplication.class, args);
  }

}
