package de.ait.word_card.cards.controller;

import de.ait.word_card.cards.dto.CardRequestDTO;
import de.ait.word_card.cards.dto.CardResponseDTO;
import de.ait.word_card.cards.service.CardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardController {
  private final CardService service;

  @GetMapping("/cards")
  public List<CardResponseDTO> getCards() {
    return service.getAllCards();
  }

  @PostMapping("/cards")
  public CardResponseDTO addCard(@RequestBody CardRequestDTO dto) {
    return service.createNewCard(dto);
  }
  @GetMapping("/cards/{id}")
  public CardResponseDTO getCardById(@PathVariable Long id) {
    return service.getCardById(id);
  }
}
