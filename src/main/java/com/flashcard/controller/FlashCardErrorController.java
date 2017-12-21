package com.flashcard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.web.ErrorController;

@Controller
public class FlashCardErrorController implements ErrorController {
	
	private static final String PATH = "/error";
	
	@RequestMapping(value = PATH)
	public String errorPage() {
		return "error";
	}
	
	@Override
	public String getErrorPath() {
		return PATH;
	}
	

}
