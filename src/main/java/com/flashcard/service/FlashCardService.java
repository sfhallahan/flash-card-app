package com.flashcard.service;

import com.flashcard.domain.FlashCard;

public interface FlashCardService {
	
	FlashCard getFlashCard(Integer id);
	
	FlashCard saveFlashCard(FlashCard card);

/*	
 * TODO Update Flash card service with remain methods
	FlashCard deleteFlashCard();
	
	List<FlashCard> getAllFlashCards();
	*/
}
