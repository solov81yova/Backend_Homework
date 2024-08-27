package de.ait.word_card;
/*
Предлагаю создать новый проект. Давайте напишем систему для повторения слов иностранного языка.
Давайте напишем сущность “Карточка слова”: В ней должны быть следующие поля:
ID,
String  language (язык оригинала),
String  word (слово),
String example (пример использования/фраза),
String translateLanguage (язык перевода),
String translation (перевод),
String group (группа карточек)
Вам необходимо написать API (по примеру того, как сделано на занятие), которая позволяет
отобразить все карточки и добавить новую карточка, вывести карточку по id.

 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WordCardApplication {

  public static void main(String[] args) {

    SpringApplication.run(WordCardApplication.class, args);
  }

}
