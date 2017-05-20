package com.flashcard.service;

import com.flashcard.domain.UserProfile;

public interface UserProfileService extends CRUDService<UserProfile>{

	UserProfile findByUsername(String username);

	
}
