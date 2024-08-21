package de.ait.car_service;
/*
В вашем проекте автомобиле реализуйте возможность использования 2 репозиториев.
Внедрите DTO
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CarServiceApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(CarServiceApplication.class,
        args);
  }

}
