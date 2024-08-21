package de.ait.car_service.service;

import de.ait.car_service.DTO.CarCreateDTO;
import de.ait.car_service.DTO.CarResponseDTO;
import de.ait.car_service.entity.Car;
import java.util.List;

public interface CarService {

  public List<CarResponseDTO> getAllCars();

  public List<CarResponseDTO> getCarsByBrand(String brand);

  public CarResponseDTO getCarById(Long id);

  public CarResponseDTO create(CarCreateDTO car);

  public CarResponseDTO delete(Long id);

  public CarResponseDTO updateCar(Long id, CarCreateDTO car);
}
