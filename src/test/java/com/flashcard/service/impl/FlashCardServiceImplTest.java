package com.flashcard.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flashcard.FlashCardApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FlashCardApplication.class)
public class FlashCardServiceImplTest {

	@Autowired
	FlashCardServiceImpl service;

	@Test
	public void saveTest() {
	}
}
