package de.ait.car_service;
/*
В проекте предыдущего ДЗ (про автомобили)  добавьте возможность создания автомобиля
(или той сущности которую вы делали), возможность удаления автомобиля.
Предыдущее задание из урока 07.
Выберете любую сущность, например Auto.
Создайте приложение, используя IDEA.  Подключите зависимость Spring Web и Lombok
По примеру написанному на занятие, создайте слои приложения, и реализуйте:
получение всех (автомобилей) при get запросе на /autos
получение одного (автомобиля) с заданным id при get запросе вида /autos/3
получение всех (автомобилей) данного бренда при get запросе на /autos?brand=bmw
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarServiceApplication.class, args);
  }

}
