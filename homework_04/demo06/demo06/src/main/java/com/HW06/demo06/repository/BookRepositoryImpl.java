package com.HW06.demo06.repository;

import com.HW06.demo06.entity.Book;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {

  private List<Book> list = List.of(
      new Book("War and Peace", "Leo Tolstoy", "Historical", new BigDecimal("12.99")),
      new Book("Crime and Punishment", "Fyodor Dostoevsky", "Philosophical",
          new BigDecimal("9.49")),
      new Book("Pride and Prejudice", "Jane Austen", "Romance", new BigDecimal("5.99")),
      new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", new BigDecimal("10.99")),
      new Book("Moby Dick", "Herman Melville", "Adventure", new BigDecimal("8.99"))
      );

  @Override
  public List<Book> findAll() {
    return list;
  }
}
