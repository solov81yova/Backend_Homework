package de.ait.car_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class CarCreateDTO {

  private String brand;
  private String model;
  private double engineVolume;
  private int year;
}
