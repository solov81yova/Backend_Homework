package de.ait.word_card;
/*
В проекте words реализуйте сущность “Группа карточек слов”(название, список слов).
Естественно, 1 карточка может быть добавлена в разные группы и группа может содержать
много карточек. Реализуйте связь много-ко -многому (настройте сущности).
Я предлагаю сделать поле со списком карточек слов в сущности группа и убрать поле group
из карточки слова.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WordCardApplication {

  public static void main(String[] args) {

    SpringApplication.run(WordCardApplication.class, args);
  }

}
