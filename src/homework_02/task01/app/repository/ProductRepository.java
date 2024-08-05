package homework_02.task01.app.repository;

import homework_02.task01.app.entity.Product;
import java.util.List;

public interface ProductRepository {
  public List<Product> findAll();
  public Product save(Product product);
}
