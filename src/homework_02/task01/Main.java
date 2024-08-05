package homework_02.task01;
/*
2.Допустим у вас дан List<Product> (класс Product реализован на занятии), необходимо написать метод,
    который вернет product по-заданному id. Используйте Stream Api

3.Допустим у вас дан List<Product> (класс Product реализован на занятии), необходимо написать метод,
   который вернет наибольший id в списке.

4.Допустим у вас дан List<Product> (класс Product реализован на занятии), необходимо написать метод,
  который вернет Map<Long,Product> (ключ id, значение product) содержащий все продукты,
   в название которых есть заданная подстрока.
 */

import homework_02.task01.app.entity.Product;
import homework_02.task01.app.repository.ProductRepository;
import homework_02.task01.app.repository.ProductRepositoryImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

//  public static Optional<Product> findProductById(List<Product> products, long id) {
//    return products.stream()
//        .filter(p -> p.getId() == id)
//        .findFirst();
//  }

  public static void findProductById(List<Product> products, Predicate<Product> predicate) {
    for (Product product : products) {
      if (predicate.test(product)) {
        System.out.println(product);
      }
    }
  }

  public static int getMaxID(ProductRepository productRepository) {
    return productRepository.findAll().stream().mapToInt(p -> Math.toIntExact(
            p.getId()))
        .max()
        .orElseThrow(() ->
            new IllegalArgumentException("The list is empty"));
  }

  //  public static Map<Long, Product> findProductsBySubstring(List<Product> products,
//      String substring) {
//    return products.stream()
//        .filter(p -> p.getTitle().toLowerCase().contains(substring.toLowerCase()))
//        .collect(Collectors.toMap(p -> p.getId(), p -> p));
//  }
  public static Map<Long, Product> findProductsBySubstring(List<Product> products,
      String substring) {
    Map<Long, Product> resultMap = new HashMap<>();
    for (Product p : products) {
      if (p.getTitle().toLowerCase().contains(substring.toLowerCase())) {
        resultMap.put(p.getId(), p);
      }
    }
    return resultMap;
  }

  public static void main(String[] args) {
    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
    Scanner scanner = new Scanner(System.in);
    long id;
    do {
      System.out.println("Enter number ID from 1 up to 7 to find the product: ");
      id = scanner.nextLong();
    } while (id < 1 || id > 7);
    System.out.println("Your ID is: " + id);

//    Optional<Product> product = findProductById(productRepository.findAll(), id);

//    long finalId = id;
//    long finalId = id;
//    product.ifPresentOrElse(
//        p -> System.out.println("Product found: " + p),
//        () -> System.out.println("Product not found with id: " + finalId)
//    );

    long finalId = id;
    findProductById(productRepository.findAll(), p -> p.getId() == finalId);
//    Predicate<Product> p1 = p -> p.getId();
//    productRepository.findAll().stream()

//    if (product.isPresent()) {
//      System.out.println("Product found: " + product.get());
//    } else {
//      System.out.println("Product not found with id: " + id);
//    }
// Поиск наибольшего id
    int maxID = getMaxID(productRepository);
    System.out.println("Max ID from the products is: " + maxID);

// Поиск продуктов по подстроке, введенной пользователем
    System.out.println("Enter substring to search for products: ");
    scanner.nextLine();
    String substring = scanner.nextLine();
    Map<Long, Product> map = findProductsBySubstring(productRepository.findAll(), substring);

    if (map.isEmpty()) {
      System.out.println("No products found with substring: " + substring);
    } else {
      map.forEach(
          (key, value) -> System.out.println("ID: " + key + ", Product: " + value.getTitle()));
    }
  }
}
