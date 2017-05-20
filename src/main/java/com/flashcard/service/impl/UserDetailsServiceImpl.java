package com.flashcard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flashcard.domain.UserProfile;
import com.flashcard.service.UserProfileService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserProfileService userProfileService;
    private Converter<UserProfile, UserDetails> userProfileToUserDetails;

    @Autowired
    public void setUserService(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @Autowired
    @Qualifier(value = "userProfileToUserDetails")
    public void setUserUserDetailsConverter(Converter<UserProfile, UserDetails> userProfileToUserDetails) {
        this.userProfileToUserDetails = userProfileToUserDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userProfileToUserDetails.convert(userProfileService.findByUsername(username));
    }
}