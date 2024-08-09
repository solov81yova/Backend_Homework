package com.HW06.demo06.service;

import com.HW06.demo06.entity.Book;
import com.HW06.demo06.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private BookRepository bookRepository;
@Autowired
  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }
}
