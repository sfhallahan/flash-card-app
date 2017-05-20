package com.flashcard.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class QuestionCategory extends AbstractDomainClass {

	private String categoryName;
	private Date dateCreated;
	private Date lastUpdated;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
