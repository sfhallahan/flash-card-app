package com.flashcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flashcard.domain.UserProfile;
import com.flashcard.service.UserProfileService;
import com.flashcard.util.QuestionSetBuilder;

@Controller
@RequestMapping("/")
public class BaseController {
	
	private UserProfileService service;
	
	@Autowired
	void setProfileService(UserProfileService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/")
	public String homePage() {
		return "index";
	}
		
	@RequestMapping(method=RequestMethod.GET, value="/create-new-profile")
	public String createNewProfile(Model model){
		model.addAttribute("userProfile", new UserProfile());
		return "createprofileform";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/create-new-profile")
	public String saveNewProfile(UserProfile profile){
		service.saveOrUpdate(profile);
		return "redirect:/";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/login")
	public String login() {
		return "login";
	}
	
	
	
	
}
