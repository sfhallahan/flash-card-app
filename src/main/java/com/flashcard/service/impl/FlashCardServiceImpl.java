package com.flashcard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcard.domain.FlashCard;
import com.flashcard.repository.FlashCardRepository;
import com.flashcard.service.FlashCardService;

@Service
public class FlashCardServiceImpl implements FlashCardService {

	private	FlashCardRepository flashCardRepo;
	
	@Autowired
	void setFlashCardRepository(FlashCardRepository flashCardRepo) {
		this.flashCardRepo = flashCardRepo;
	}
	
	@Override
	public FlashCard getFlashCard(Integer id) {
		return flashCardRepo.findOne(id);
	}

	@Override
	public FlashCard saveFlashCard(FlashCard card) {
		return flashCardRepo.save(card);
	}


}
