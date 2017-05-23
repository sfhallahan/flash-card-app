package com.flashcard.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FLASH_CARD")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "flash_card_id"))})
public class FlashCard extends AbstractDomainClass {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_profile_id")
	private UserProfile userProfile;
	
	@Column(name = "QUESTION")
	private String question;
	
	@Column(name = "ANSWER")
	private String answer;

	public FlashCard(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
		
	public FlashCard() {
		// Empty constructor
	}

	public Category getCategory() {
		return category;
	}

	public void setCategoryId(Category category) {
		this.category = category;
	}

	
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
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
