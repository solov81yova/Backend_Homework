package de.ait.car_service.service;

import de.ait.car_service.DTO.CarCreateDTO;
import de.ait.car_service.DTO.CarResponseDTO;
import de.ait.car_service.entity.Car;
import de.ait.car_service.repository.CarRepository;
import de.ait.car_service.repository.CarRepositoryImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

  private final CarRepository repository;

  @Autowired
  public CarServiceImpl(@Qualifier("actualRepository") CarRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<CarResponseDTO> getAllCars() {
    return CarResponseDTO.of(repository.findAll());
  }

  @Override
  public List<CarResponseDTO> getCarsByBrand(String brand) {
    return getAllCars()
        .stream()
        .filter(car -> car.getBrand().equalsIgnoreCase(brand))
        .toList();
  }

  @Override
  public CarResponseDTO getCarById(Long id) {
    Car findCar = repository
        .findAll()
        .stream()
        .filter(car -> car.getId().equals(id))
        .findAny()
        .get();
    return CarResponseDTO.of(findCar);
  }

  @Override
  public CarResponseDTO create(CarCreateDTO carDTO) {
    Car newCar = new Car(null, carDTO.getBrand(), carDTO.getModel(),
        carDTO.getEngineVolume(), carDTO.getYear());
    return CarResponseDTO.of(repository.save(newCar));
  }

  @Override
  public CarResponseDTO delete(Long id) {
    // Находим автомобиль по ID, если не найдено - выбрасываем исключение
    Car carToDelete = repository
        .findAll()  // Получаем все автомобили
        .stream()   // Преобразуем в поток
        .filter(car -> car.getId().equals(id))  // Фильтруем по ID
        .findAny()  // Ищем любой подходящий элемент
        .orElseThrow(() -> new RuntimeException("Car not found"));  // Если не найдено, выбрасываем исключение
    // Удаляем автомобиль
    repository.deleteById(id);
    // Возвращаем DTO с информацией об удаленном автомобиле
    return CarResponseDTO.of(carToDelete);
  }

  @Override
  public CarResponseDTO updateCar(Long id, CarCreateDTO dtoCar) {
    Car car = new Car(id, dtoCar.getBrand(), dtoCar.getModel(), dtoCar.getEngineVolume(),
        dtoCar.getYear());
    return CarResponseDTO.of(repository.save(car));
  }

}
