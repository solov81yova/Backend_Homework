package de.ait.word_card.cards.controller;

import de.ait.word_card.cards.dto.CardRequestDTO;
import de.ait.word_card.cards.dto.CardResponseDTO;
import de.ait.word_card.cards.service.CardService;
import de.ait.word_card.groups.dto.GroupRequestDTO;
import de.ait.word_card.groups.dto.GroupResponseDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("/cards/by-word")
  public CardResponseDTO getCardByWord(@RequestParam(name = "word") String word) {
    return service.getCardByWord(word);
  }

  @GetMapping("/cards/by-languages")
  public List<CardResponseDTO> getCardsByLanguages(
      @RequestParam(name = "language") String language,
      @RequestParam(name = "translateLanguage") String translateLanguage) {
    return service.getCardsByLanguages(language, translateLanguage);
  }

  @DeleteMapping("/cards/{id}")
  public CardResponseDTO deleteCardById(@PathVariable(name = "id") Long id) {
    return service.deleteCard(id);
  }

  @PutMapping("/cards/{id}")
  public CardResponseDTO updateCardById(@PathVariable(name = "id") Long id, @RequestBody CardRequestDTO dto) {
    return service.updateCard(id, dto);
  }

  @PostMapping("/groups")
  public GroupResponseDTO createGroup(@RequestBody GroupRequestDTO dto) {
    return service.createNewGroup(dto);
  }

  @PostMapping("/groups/{groupId}/cards/{cardId}")
  public GroupResponseDTO addCardToGroup(@PathVariable(name = "groupId") Long groupId,
      @PathVariable(name = "cardId") Long cardId) {
    return service.addCardToGroup(groupId, cardId);
  }

  @GetMapping("/groups/{id}")
  public GroupResponseDTO getGroupById(@PathVariable(name = "id") Long id) {
    return service.getGroupById(id);
  }
}