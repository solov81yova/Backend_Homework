package com.HW06.demo06.repository;

import com.HW06.demo06.entity.Book;
import java.util.List;

public interface BookRepository {
  public List<Book> findAll();

}
