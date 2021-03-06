package com.flashcard.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROLE")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "role_id"))})
public class Role extends AbstractDomainClass {

	@Column(name = "ROLE")
	private String role;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	private List<UserProfile> users = new ArrayList<>();

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<UserProfile> getUsers() {
		return users;
	}

	public void setUsers(List<UserProfile> users) {
		this.users = users;
	}

	public void addUser(UserProfile user) {
		if (!this.users.contains(user)) {
			this.users.add(user);
		}

		if (!user.getRoles().contains(this)) {
			user.getRoles().add(this);
		}
	}

	public void removeUser(UserProfile user) {
		this.users.remove(user);
		user.getRoles().remove(this);
	}

}