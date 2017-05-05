package com.flashcard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flashcard.domain.FlashCard;

@Repository
public interface FlashCardRepository extends CrudRepository<FlashCard, Integer>{

}
