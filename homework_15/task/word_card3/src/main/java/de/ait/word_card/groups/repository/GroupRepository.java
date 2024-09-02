package de.ait.word_card.groups.repository;

import de.ait.word_card.groups.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GroupRepository extends JpaRepository<Group, Long> {
}