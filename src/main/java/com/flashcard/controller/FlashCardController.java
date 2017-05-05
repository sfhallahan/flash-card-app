package com.flashcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flashcard.domain.FlashCard;
import com.flashcard.service.FlashCardService;

@Controller
public class FlashCardController {

	private FlashCardService flashCardService;
	
	@Autowired
	public void setFlashCardService(FlashCardService flashCardService) {
		this.flashCardService = flashCardService;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="flashcard/new-card")
	public String newCard(Model model) {
		model.addAttribute("flashcard", new FlashCard());
		return "flashcardform";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="flashcard/new-card")
	public String saveFlashCard(FlashCard flashCard) {
		flashCardService.saveFlashCard(flashCard);
		return "redirect:/flashcard/new-card";
	}
}
