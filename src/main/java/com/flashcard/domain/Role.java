package com.flashcard.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role extends AbstractDomainClass {

	private String role;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable
	// ~ defaults to @JoinTable(name = "USER_ROLE", joinColumns =
	// @JoinColumn(name = "role_id"),
	// inverseJoinColumns = @joinColumn(name = "user_id"))
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