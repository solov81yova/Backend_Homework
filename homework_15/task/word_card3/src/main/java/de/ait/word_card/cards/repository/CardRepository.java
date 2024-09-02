package de.ait.word_card.cards.repository;


import de.ait.word_card.cards.entity.WordCard;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<WordCard, Long> {

  List<WordCard> findByWordIgnoreCase(String word);

  List<WordCard> findByLanguageAndTranslateLanguage(String language, String translateLanguage);

}
