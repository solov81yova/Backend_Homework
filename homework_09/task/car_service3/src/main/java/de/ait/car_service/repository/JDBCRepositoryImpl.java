package de.ait.car_service.repository;

import de.ait.car_service.entity.Car;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCRepositoryImpl implements CarRepository {

  private static final String DRIVER = "org.postgresql.Driver";
  private static final String URL = "jdbc:postgresql://localhost:5432/";
  private static final String DB = "cars";
  private static final String USER = "postgres";
  private static final String PASSWORD = "soloviova";


  public static void loadDriver() {
    try {
      Class.forName(DRIVER);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("Driver not found " + DRIVER);
    }
  }

  public static Connection getConnection() {
    try {
      return DriverManager.getConnection(URL + DB, USER, PASSWORD);
    } catch (SQLException e) {
      throw new RuntimeException("Could not connect to " + URL + DB);
    }
  }

  public static List<Car> getAllCars() {

    String query = "SELECT id, brand, model, engine_volume, year FROM cars.t_cars";

    try (Connection connection = getConnection()) {
      if (connection == null) {
        throw new SQLException();
      }
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);


      List<Car> result = new ArrayList<>();
      while (resultSet.next()) {
        Long id = resultSet.getLong("id");
        String brand = resultSet.getString("brand");
        String model = resultSet.getString("model");
        double engineVolume = resultSet.getDouble("engine_volume");
        int year = resultSet.getInt("year");

        Car car = new Car(id, brand, model, engineVolume, year);
        result.add(car);
      }
      return result;

    } catch (SQLException e) {
      throw new RuntimeException("Error! Check getAllCars method");
    }
  }

  public static Car createCar(Car car) {

    String query = "INSERT INTO cars.t_cars (brand, model, engine_volume, year) VALUES (?, ?, ?, ?)";
    try (Connection connection = getConnection()) {
      if (connection == null) {
        throw new SQLException();
      }

      PreparedStatement statement = connection.prepareStatement(query,
          Statement.RETURN_GENERATED_KEYS);

      statement.setString(1, car.getBrand());
      statement.setString(2, car.getModel());
      statement.setDouble(3, car.getEngineVolume());
      statement.setInt(4, car.getYear());

      int rows = statement.executeUpdate();
      if (rows == 0) {
        throw new SQLException("Create user error");
      }

      ResultSet resultSet = statement.getGeneratedKeys();

      if (!resultSet.next()) {
        throw new SQLException("Id not created");
      } else {
        long id = resultSet.getLong(1);
        car.setId(id);
        return car;
      }
    } catch (SQLException e) {
      throw new RuntimeException("Error! Check createCar method");
    }
  }

  @Override
  public List<Car> findAll() {
    return null;
  }

  @Override
  public Car findById(Long id) {
    return null;
  }

  @Override
  public Car save(Car car) {
    return null;
  }

  @Override
  public Car delete(Long id) {
    return null;
  }
}
