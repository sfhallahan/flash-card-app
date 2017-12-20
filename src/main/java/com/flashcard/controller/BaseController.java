package com.flashcard.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.flashcard.domain.UserProfile;
import com.flashcard.service.UserProfileService;

@Controller
public class BaseController {
	
	private UserProfileService userProfileService;
	
	@Autowired
	void setProfileService(UserProfileService userProfileservice) {
		this.userProfileService = userProfileService;
	}
	
	@RequestMapping(value = "/")
	public String homePage(Model model, @ModelAttribute("userProfile") UserProfile userProfile) {
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if(userProfile == null) {
				setUserProfile(model);
			}
			return "index";
		} else {
			return "redirect:/login";
		}
	}
		
	@RequestMapping(method=RequestMethod.GET, value="/create-new-profile")
	public String createNewProfile(Model model){
		model.addAttribute("userProfile", new UserProfile());
		return "createprofileform";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/create-new-profile")
	public String saveNewProfile(Model model, UserProfile userProfile){
		userProfileService.saveOrUpdate(userProfile);
		model.addAttribute("userProfile", userProfile);
		return "redirect:/";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/login")
	public String login() {
		return "login";
	}
	
	public void setUserProfile(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(username);
		UserProfile userProfile = userProfileService.findByUsername(username);
		model.addAttribute("userProfile", userProfile);
	}
}
