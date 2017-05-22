package com.flashcard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.flashcard.domain.FlashCard;
import com.flashcard.service.FlashCardService;
import com.flashcard.util.QuestionSetBuilder;

@SessionAttributes("questionSet")
@Controller
@RequestMapping("/flashcard")
public class FlashCardController {

	private FlashCardService flashCardService;
	private ArrayList<FlashCard> questionSet;
	private QuestionSetBuilder builder;

	@Autowired
	public void setFlashCardService(FlashCardService flashCardService) {
		this.flashCardService = flashCardService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/new-card")
	public String newCard(Model model) {
		model.addAttribute("flashcard", new FlashCard());
		return "flashcardform";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/new-card")
	public String saveFlashCard(FlashCard flashCard) {
		flashCardService.saveFlashCard(flashCard);
		return "redirect:/flashcard/new-card";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/quiz-setup")
	public String quizSetup(Model model) {
		model.addAttribute("cardBuilder", new QuestionSetBuilder());
		return "quizsetupform";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/quiz-setup")
	public String buildQuiz(QuestionSetBuilder builder) {
		this.builder = builder;
		this.questionSet = flashCardService.buildQuestionSet(builder);
		return "redirect:/flashcard/quiz/1";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/quiz/{cardNumber}")
	public String nextQuestion(@PathVariable int cardNumber) {
		if (cardNumber == builder.getQuestionCount()) {
			return "index";
		} else {
			cardNumber = cardNumber + 1;
			return "redirect:/flashcard/quiz/" + cardNumber;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/quiz/{cardNumber}")
	public String updateNextQuestion(Model model, @PathVariable int cardNumber) {
		model.addAttribute("flashcard", questionSet.get(cardNumber - 1));
		return "quizform";
	}

}
