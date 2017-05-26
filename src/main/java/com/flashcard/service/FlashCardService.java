package com.flashcard.service;

import java.util.ArrayList;

import com.flashcard.domain.FlashCard;
import com.flashcard.util.QuestionSetBuilder;

public interface FlashCardService {
	
	FlashCard getFlashCard(Integer id);
	
	FlashCard saveFlashCard(FlashCard card);

/*	
 * TODO Update Flash card service with remain methods
	FlashCard deleteFlashCard();
	
	Iterable<FlashCard> findFlashCardByCategory()
	
*/	
	Iterable<FlashCard> getAllFlashCards();
	
	ArrayList<FlashCard> buildQuestionSet(QuestionSetBuilder builder);
}
