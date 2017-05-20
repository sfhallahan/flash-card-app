package com.flashcard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flashcard.domain.Role;
import com.flashcard.domain.UserProfile;
import com.flashcard.repository.UserProfileRepository;
import com.flashcard.service.EncryptionService;
import com.flashcard.service.RoleService;
import com.flashcard.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	private UserProfileRepository repo;
	private RoleService roleService;

	@Autowired
	void setUserProfileRepository(UserProfileRepository repo) {
		this.repo = repo;
	}
	
	@Autowired
	void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	private EncryptionService encryptionService;

	@Autowired
	public void setEncryptionService(EncryptionService encryptionService) {
		this.encryptionService = encryptionService;
	}

	@Override
	public List<UserProfile> listAll() {
		List<UserProfile> users = new ArrayList<>();
		repo.findAll().forEach(users::add);
		return users;
	}

	@Override
	public UserProfile getById(Integer id) {
		repo.findOne(id);
		return null;
	}

	@Override
	public UserProfile saveOrUpdate(UserProfile user) {
		if (user.getPassword() != null) {
			user.setEncryptedPassword(encryptionService.encryptString(user.getPassword()));
		}
		if (user.getRoles().isEmpty()) {
			List<Role> roles = new ArrayList<>();
			roles = (List<Role>) roleService.listAll();
			roles.forEach(role -> {
	            if (role.getRole().equalsIgnoreCase("USER")) {
	            	user.addRole(role);
	            }
            });
		}
		return repo.save(user);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repo.delete(id);
	}

	@Override
	public UserProfile findByUsername(String username) {
		return repo.findByUsername(username);
	}


}
