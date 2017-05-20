package com.flashcard.domain;

import javax.persistence.Entity;

@Entity
public class FlashCard extends AbstractDomainClass {

	private Integer categoryId;
	private String question;
	private String answer;

	public FlashCard(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
		
	public FlashCard() {
		// Empty constructor
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
