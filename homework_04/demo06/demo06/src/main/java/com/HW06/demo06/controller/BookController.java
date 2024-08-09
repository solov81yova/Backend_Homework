package com.HW06.demo06.controller;

import com.HW06.demo06.entity.Book;
import com.HW06.demo06.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  private BookService bookService;
@Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }
@GetMapping("/books")
  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }
}
