package de.ait.car_service.repository;


import de.ait.car_service.entity.Car;
import java.util.List;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JDBCRepositoryImpl implements CarRepository {

  private final JdbcTemplate jdbcTemplate;
  private final DataSource dataSource;

  private static final RowMapper<Car> CAR_ROW_MAPPER = (row, rowNum) -> {
    Long id = row.getLong("id");
    String brand = row.getString("brand");
    String model = row.getString("model");
    double engineVolume = row.getDouble("engine_volume");
    int year = row.getInt("year");

    Car car = new Car(id, brand, model, engineVolume, year);
    return car;

  };

  @Override
  public List<Car> findAll() {
    String queryStr = "SELECT id, brand, model, engine_volume, year FROM t_cars";
    return jdbcTemplate.query(queryStr, CAR_ROW_MAPPER);
  }

  @Override
  public Car save(Car car) {
    if (car.getId() == null) {
      return createCar(car);
    } else {
      return update(car);
    }
  }

  private Car update(Car car) {
    String queryStr = "UPDATE t_cars SET brand=?, model=?, engine_volume=?, year=? WHERE id=?";
    int update = jdbcTemplate.update(
        queryStr,
        car.getBrand(),
        car.getModel(),
        car.getEngineVolume(),
        car.getYear(),
        car.getId()
    );
    if (update != 1) {
      throw new RuntimeException("update failed");
    }
    return car;
  }

  public Car createCar(Car car) {

    SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource)
        .usingGeneratedKeyColumns("id")
        .withTableName("t_cars");

    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("brand", car.getBrand());
    params.addValue("model", car.getModel());
    params.addValue("engine_volume", car.getEngineVolume());
    params.addValue("year", car.getYear());

    long newId = jdbcInsert.executeAndReturnKey(params).longValue();
    car.setId(newId);
    return car;
  }

  @Override
  public Car findById(Long id) {
    String queryStr = "SELECT id, brand, model, engine_volume, year FROM t_cars WHERE id = ?";
    try {
      return jdbcTemplate.queryForObject(queryStr, CAR_ROW_MAPPER, id);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  @Override
  public Car delete(Long id) {
    Car carToDelete = findById(id);
    if (carToDelete == null) {
      throw new RuntimeException("Car not found for deletion with id: " + id);
    }

    String queryStr = "DELETE FROM t_cars WHERE id = ?";
    int deleted = jdbcTemplate.update(queryStr, id);
    if (deleted != 1) {
      throw new RuntimeException("Deletion failed for id: " + id);
    }
    return carToDelete;
  }

  //@Override
  public List<Car> getAllCars() {
    return getAllCars();
  }
}
