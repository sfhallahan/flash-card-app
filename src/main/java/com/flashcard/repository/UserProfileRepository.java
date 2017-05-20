package com.flashcard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.flashcard.domain.UserProfile;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Integer>{
	UserProfile findByUsername(String username);

}
