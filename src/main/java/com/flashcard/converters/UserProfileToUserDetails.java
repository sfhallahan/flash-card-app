package com.flashcard.converters;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.flashcard.domain.UserProfile;
import com.flashcard.service.security.UserDetailsImpl;

@Component
public class UserProfileToUserDetails implements Converter<UserProfile, UserDetails> {

	@Override
	public UserDetails convert(UserProfile user) {
		UserDetailsImpl userDetails = new UserDetailsImpl();

		if (user != null) {
			userDetails.setUsername(user.getUsername());
			userDetails.setPassword(user.getEncryptedPassword());
			userDetails.setEnabled(user.getEnabled());
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
			user.getRoles().forEach(role -> {
				authorities.add(new SimpleGrantedAuthority(role.getRole()));
			});
			userDetails.setAuthorities(authorities);
		}

		return userDetails;
	}
}
