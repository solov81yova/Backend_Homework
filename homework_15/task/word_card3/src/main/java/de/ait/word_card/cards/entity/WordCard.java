package de.ait.word_card.cards.entity;

import de.ait.word_card.groups.entity.Group;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString

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

@ManyToMany(mappedBy = "cards")
  private List<Group> groups = new ArrayList<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WordCard card = (WordCard) o;
    return Objects.equals(id, card.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
