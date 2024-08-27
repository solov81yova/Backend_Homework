package de.ait.word_card.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardRequestDTO {

  private String language;
  private String word;
  private String example;
  private String translateLanguage;
  private String translation;
  private String group;

}
