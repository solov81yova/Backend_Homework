package de.ait.word_card.cards.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "cards")
public class WordCard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "language")
  private String language;

  @Column(name = "word")
  private String word;

  @Column(name = "example")
  private String example;

  @Column(name = "translate_language")
  private String translateLanguage;

  @Column(name = "translation")
  private String translation;

  @Column(name = "group")
  private String group;

}
