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
@Table(name = "CATEGORY")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "CATEGORY_ID"))})
public class Category extends AbstractDomainClass {
	
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_PROFILE_ID")
	private UserProfile userProfile;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
}
