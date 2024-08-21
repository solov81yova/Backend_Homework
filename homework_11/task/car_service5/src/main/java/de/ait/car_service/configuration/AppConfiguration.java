package de.ait.car_service.configuration;

import de.ait.car_service.repository.CarRepository;
import de.ait.car_service.repository.CarRepositoryImpl;
import de.ait.car_service.repository.JDBCRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;


@Configuration
@RequiredArgsConstructor
public class AppConfiguration {

  @Value("${repository.name}")
  private String repositoryName;

  private final ConfigurableApplicationContext appContext;

  @Bean
  public CarRepository actualRepository() {
    if (repositoryName.equalsIgnoreCase("cars")) {
      return appContext.getBean(CarRepositoryImpl.class);
    } else {
      return appContext.getBean(JDBCRepositoryImpl.class);
    }
  }

}
