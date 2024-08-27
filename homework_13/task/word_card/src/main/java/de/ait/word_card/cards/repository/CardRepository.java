package de.ait.word_card.cards.repository;


import de.ait.word_card.cards.entity.WordCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<WordCard, Long> {

}
