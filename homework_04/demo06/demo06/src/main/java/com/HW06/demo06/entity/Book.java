package com.HW06.demo06.entity;

import java.math.BigDecimal;

public class Book {
  private String title;
  private String author;
  private String genre;
  private BigDecimal price;

  public Book(String title, String author, String genre, BigDecimal price) {
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getGenre() {
    return genre;
  }

  public BigDecimal getPrice() {
    return price;
  }
}
