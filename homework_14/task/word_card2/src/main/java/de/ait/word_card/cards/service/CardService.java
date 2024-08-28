package de.ait.word_card.cards.service;

import de.ait.word_card.cards.dto.CardRequestDTO;
import de.ait.word_card.cards.dto.CardResponseDTO;
import java.util.List;

public interface CardService {

  List<CardResponseDTO> getAllCards();

  CardResponseDTO createNewCard(CardRequestDTO dto);

  CardResponseDTO getCardById(Long id);

  List<CardResponseDTO> getCardsByLanguages(String language, String translateLanguage);

  CardResponseDTO getCardByWord(String word);

  CardResponseDTO deleteCard(Long id);

  CardResponseDTO updateCard(Long id, CardRequestDTO dto);

}
