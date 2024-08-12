package de.ait.car_service.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Car {

  private Long id;
  private String brand;
  private String model;
  private double engineVolume;
  private int year;
}
