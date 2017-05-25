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

@SessionAttributes({ "questionSet", "questionSetBuilder" })
@Controller
@RequestMapping("/flashcard")
public class FlashCardController {

	private FlashCardService flashCardService;

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
		model.addAttribute("questionSetBuilder", new QuestionSetBuilder());
		return "quizsetupform";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/quiz-setup")
	public String buildQuiz(Model model, @ModelAttribute("questionSetBuilder") QuestionSetBuilder questionSetBuilder) {
		ArrayList<FlashCard> questionSet = flashCardService.buildQuestionSet(questionSetBuilder);
		model.addAttribute("questionSet", questionSet);
		return "redirect:/flashcard/quiz/1";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/quiz/{cardNumber}")
	public String nextQuestion(@PathVariable int cardNumber,
			@ModelAttribute("questionSetBuilder") QuestionSetBuilder questionSetBuilder) {
		if (cardNumber == questionSetBuilder.getQuestionCount()) {
			return "redirect:/";
		} else {
			cardNumber = cardNumber + 1;
			return "redirect:/flashcard/quiz/" + cardNumber;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/quiz/{cardNumber}")
	public String updateNextQuestion(Model model, @PathVariable int cardNumber,
			@ModelAttribute("questionSet") ArrayList<FlashCard> questionSet) {
		model.addAttribute("flashcard", questionSet.get(cardNumber - 1));
		return "quizform";
	}

}
