package com.flashcard.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category extends AbstractDomainClass {

	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	

}
