package com.flashcard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flashcard.domain.Category;
import com.flashcard.repository.CategoryRepository;
import com.flashcard.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;
	
	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List<Category> listAll() {
		List<Category> categories = new ArrayList<Category>();
		categoryRepository.findAll().forEach(categories::add);
		return categories;
	}

	@Override
	public Category getById(Integer id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public Category saveOrUpdate(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void delete(Integer id) {
		categoryRepository.delete(id);
	}

	@Override
	public ArrayList<Category> getCategoriesByUsername(String username) {
		ArrayList<Category> categories = (ArrayList<Category>) categoryRepository.getCategoriesByUsername(username);
		return categories;
	}

}
