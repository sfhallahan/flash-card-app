package com.flashcard.domain;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class AbstractDomainClass {
	
	private Date dateCreated;
	private Date lastUpdated;

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
	
	@PreUpdate
	@PrePersist
	public void updateTimeStamps() {
		lastUpdated = new Date();
		if(dateCreated == null) {
			dateCreated = new Date();
		}
	}
	
}
