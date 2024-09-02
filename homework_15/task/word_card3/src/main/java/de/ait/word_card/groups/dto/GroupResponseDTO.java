package de.ait.word_card.groups.dto;

import de.ait.word_card.cards.dto.CardResponseDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupResponseDTO {

  private Long id;
  private String name;
  private List<CardResponseDTO> cards;

}
