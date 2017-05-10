package com.flashcard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.flashcard.domain.FlashCard;
import com.flashcard.domain.QuestionSetBuilder;
import com.flashcard.service.FlashCardService;

@SessionAttributes("questionSet")
@Controller
public class FlashCardController {

	private FlashCardService flashCardService;
	private ArrayList<FlashCard> questionSet;
	private QuestionSetBuilder builder;
	
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
	
	@RequestMapping(method=RequestMethod.GET, value="flashcard/quiz-setup")
	public String quizSetup(Model model) {
		model.addAttribute("cardBuilder", new QuestionSetBuilder());
		return "quizsetupform";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="flashcard/quiz-setup")
	public String buildQuiz(QuestionSetBuilder builder) {
		this.builder = builder;
		this.questionSet = flashCardService.buildQuestionSet(builder);
		return "redirect:/flashcard/quiz/0";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="flashcard/quiz/{cardNumber}")
	public String firstQuestion(Model model, @PathVariable int cardNumber) {
		model.addAttribute("flashcard", questionSet.get(cardNumber));
		return "quizform";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="flashcard/quiz/{cardNumber}")
	public String nextQuestion(Model model, @PathVariable int cardNumber) {
		int nextCard = cardNumber + 1;
		model.addAttribute("nextCard", nextCard);
		return "redirect:/flashcard/quiz/"+ nextCard;
	}
	
}
