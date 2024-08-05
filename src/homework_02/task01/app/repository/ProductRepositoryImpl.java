package homework_02.task01.app.repository;

import homework_02.task01.app.entity.Product;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {

  private static Map<Long, Product> map = new HashMap<>();
  static {
    map.put(1L,new Product(1L,"Milk",new BigDecimal("1.79"),"12345-i"));
    map.put(2L,new Product(2L,"Kefir",new BigDecimal("1.6"),"12346-i"));
    map.put(3L,new Product(3L,"Butter",new BigDecimal("3.79"),"12945-i"));
    map.put(4L,new Product(4L,"Cheese",new BigDecimal("4.79"),"12946-i"));
    map.put(5L,new Product(5L,"Cream",new BigDecimal("2.99"),"12948-i"));
    map.put(6L,new Product(6L,"Sausage",new BigDecimal("3.99"),"12848-i"));
    map.put(7L,new Product(7L,"Potato",new BigDecimal("2.49"),"12648-i"));
  }


  @Override
  public List<Product> findAll() {
    return map
        .values()
        .stream()
        .toList();
  }

  @Override
  public Product save(Product product) {
    return map.put(product.getId(),product);
  }
}