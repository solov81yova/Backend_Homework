package de.ait.word_card.cards.service;

import de.ait.word_card.cards.dto.CardRequestDTO;
import de.ait.word_card.cards.dto.CardResponseDTO;
import de.ait.word_card.cards.repository.CardRepository;
import de.ait.word_card.cards.entity.WordCard;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {

  private final CardRepository repository;
  private final ModelMapper mapper;


  @Override
  public List<CardResponseDTO> getAllCards() {
    return repository.findAll().stream()
        .map(c -> mapper.map(c, CardResponseDTO.class))
        .toList();
  }

  @Override
  public CardResponseDTO createNewCard(CardRequestDTO dto) {
    WordCard entity = mapper.map(dto, WordCard.class);
    entity = repository.save(entity);
    return mapper.map(entity, CardResponseDTO.class);
  }

  @Override
  public CardResponseDTO getCardById(Long id) {
    WordCard entity = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Card with id " + id + " not found"));
    return mapper.map(entity, CardResponseDTO.class);
  }

  @Override
  public CardResponseDTO getCardByWord(String word) {
    WordCard entity = repository.findByWordIgnoreCase(word)
        .stream()
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Card with word " + word + " not found"));
    return mapper.map(entity, CardResponseDTO.class);
  }

  @Override
  public List<CardResponseDTO> getCardsByLanguages(String language, String translateLanguage) {
    return repository.findByLanguageAndTranslateLanguage(language, translateLanguage).stream()
        .map(c -> mapper.map(c, CardResponseDTO.class))
        .toList();
  }

  @Override
  public CardResponseDTO deleteCard(Long id) {
    WordCard card = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Card with id " + id + " not found"));
    repository.deleteById(id);
    return mapper.map(card, CardResponseDTO.class);
  }

  @Override
  @Transactional
  public CardResponseDTO updateCard(Long id, CardRequestDTO dto) {
    WordCard entity = mapper.map(dto, WordCard.class);
    entity.setId(id);
    entity = repository.save(entity);
    return mapper.map(entity, CardResponseDTO.class);
  }
}
