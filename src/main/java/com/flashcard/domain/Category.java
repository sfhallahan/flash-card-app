package com.flashcard.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "category_id"))})
public class Category extends AbstractDomainClass {
	
	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	

}
