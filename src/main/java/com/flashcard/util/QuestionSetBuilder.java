package com.flashcard.util;

import java.util.ArrayList;
import java.util.Collections;

import com.flashcard.domain.FlashCard;
import com.flashcard.domain.Category;
import com.google.common.collect.Lists;


public class QuestionSetBuilder {
	
	private int questionCount;
	private Category category;
	
	
	public QuestionSetBuilder(int questionCount, Category category){
		this.questionCount = questionCount;
		this.category = category;
	}
	
	
	public QuestionSetBuilder(int questionCount){
		this.questionCount = questionCount;
	}
	
	public QuestionSetBuilder(){}
	
	
	public ArrayList<FlashCard> randomizeCards(Iterable<FlashCard> allCards) {
		
		ArrayList<FlashCard> potentialQuestions = Lists.newArrayList(allCards);
		ArrayList<FlashCard> questionSet = new ArrayList<FlashCard>();
		
		int maxQuestionCount = potentialQuestions.size();		
		
		if(questionCount > maxQuestionCount) {
			questionCount = maxQuestionCount;
		}
		
		Collections.shuffle(potentialQuestions);
		
		
		for(int i = 0; i < questionCount; i++) {
			questionSet.add(potentialQuestions.get(i));
		}
		
		return questionSet;
	}


	public int getQuestionCount() {
		return questionCount;
	}


	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
