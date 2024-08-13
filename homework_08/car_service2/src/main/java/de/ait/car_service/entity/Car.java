package de.ait.car_service.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
public class Car {

  private Long id;
  private String brand;
  private String model;
  private double engineVolume;
  private int year;
}
