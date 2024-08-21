package de.ait.car_service.DTO;

import de.ait.car_service.entity.Car;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class CarResponseDTO {

  private Long id;
  private String brand;
  private String model;
  private double engineVolume;

  public static CarResponseDTO of(Car car) {
    return  CarResponseDTO.builder()
        .brand(car.getBrand())
        .model(car.getModel())
        .engineVolume(car.getEngineVolume())
        .id(car.getId())
        .build();
  }

  public static List<CarResponseDTO> of(List<Car> carEntity) {
    return carEntity
        .stream()
        .map(CarResponseDTO::of)
        .toList();
  }
}
