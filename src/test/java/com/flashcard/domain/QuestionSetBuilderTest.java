package com.flashcard.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flashcard.util.QuestionSetBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionSetBuilderTest {
	
	
	@Test 
	public void randomizeCardsTest() {
		QuestionSetBuilder builder = new QuestionSetBuilder(4);
		ArrayList<FlashCard> mockSet = new ArrayList<FlashCard>(); 
		mockSet.add(new FlashCard("This is question 1", "This is answer 1"));
		mockSet.add(new FlashCard("This is question 2", "This is answer 2"));
		mockSet.add(new FlashCard("This is question 3", "This is answer 3"));
		mockSet.add(new FlashCard("This is question 4", "This is answer 4"));
		mockSet.add(new FlashCard("This is question 5", "This is answer 5"));
		Iterable<FlashCard> mockSetFinal = mockSet; 
		
		ArrayList<FlashCard> randomSet1 = builder.randomizeCards(mockSetFinal);
		ArrayList<FlashCard> randomSet2 = builder.randomizeCards(mockSetFinal);
		assertThat(randomSet1.size()).isEqualTo(4);
		assertFalse(randomSet1.get(0).equals(randomSet2.get(0)));
		
	}
	
}
