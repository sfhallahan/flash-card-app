package com.flashcard.service;

import java.util.List;

import com.flashcard.domain.Category;

public interface CategoryService extends CRUDService<Category> {

	List<Category> getCategoriesByUsername(String username);
	
}
