package de.ait.word_card;
/*
Используя полученные знания реализуйте в проекте words следующие возможности:
поиск всех карточек с заданной комбинацией языков (исходного и языка перевода)
поиск карточки по слову
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WordCardApplication {

  public static void main(String[] args) {

    SpringApplication.run(WordCardApplication.class, args);
  }

}
