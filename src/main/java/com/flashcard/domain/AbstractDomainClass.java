package com.flashcard.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractDomainClass implements DomainObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "HIBERNATE_SEQUENCE")
	Integer id;

	@Version
	@Column(name = "VERSION")
	private Integer version;
	
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	@Column(name = "LAST_UPDATED")
	private Date lastUpdated;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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

	@PreUpdate
	@PrePersist
	public void updateTimeStamps() {
		lastUpdated = new Date();
		if (dateCreated == null) {
			dateCreated = new Date();
		}
	}

}
