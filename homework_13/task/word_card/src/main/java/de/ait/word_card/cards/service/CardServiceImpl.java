package de.ait.word_card.cards.service;

import de.ait.word_card.cards.dto.CardRequestDTO;
import de.ait.word_card.cards.dto.CardResponseDTO;
import de.ait.word_card.cards.repository.CardRepository;
import de.ait.word_card.cards.entity.WordCard;
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
}
