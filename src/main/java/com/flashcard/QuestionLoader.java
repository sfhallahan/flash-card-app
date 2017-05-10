package com.flashcard;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.flashcard.domain.FlashCard;
import com.flashcard.repository.FlashCardRepository;
import java.util.Date;

@Component
public class QuestionLoader implements ApplicationListener<ContextRefreshedEvent> {

	private FlashCardRepository flashCardRepo;

	private Logger log = Logger.getLogger(QuestionLoader.class);

	@Autowired
	public void setProductRepository(FlashCardRepository flashCardRepo) {
		this.flashCardRepo = flashCardRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		FlashCard flashCardOne = new FlashCard();
		flashCardOne.setCardId(1000);
		flashCardOne.setQuestion("What does EC2 stand for?");
		flashCardOne.setAnswer("Elastic Compute Cloud");
		Date currentDateTime = new Date();
		flashCardOne.setDateCreated(currentDateTime);
		flashCardOne.setLastUpdated(currentDateTime);
		flashCardRepo.save(flashCardOne);

		log.info("Saved Flash Card " + flashCardOne.getCardId());

		FlashCard flashCardTwo = new FlashCard();
		flashCardTwo.setCardId(1001);
		flashCardTwo.setQuestion("What are the 4 pricing options you have for EC2 instances?");
		flashCardTwo.setAnswer("On-demand, spot, reserved, dedicated hosts");
		Date currentDateTime2 = new Date();
		flashCardTwo.setDateCreated(currentDateTime2);
		flashCardTwo.setLastUpdated(currentDateTime2);
		flashCardRepo.save(flashCardTwo);

		log.info("Saved Flash Card " + flashCardTwo.getCardId());

		FlashCard flashCardThree = new FlashCard();
		flashCardThree.setCardId(1002);
		flashCardThree.setQuestion("What are the 5 different volume types available for EBS?");
		flashCardThree.setAnswer("General Purpose SSD (GP2), Provisioned IOPS SSD (IO1)"
				+ "Throughput Optimized HDD (ST1), Cold HDD (SC1), Magnetic (Standard)");
		Date currentDateTime3 = new Date();
		flashCardThree.setDateCreated(currentDateTime3);
		flashCardThree.setLastUpdated(currentDateTime3);
		flashCardRepo.save(flashCardThree);

		log.info("Saved Flash Card " + flashCardThree.getCardId());

		FlashCard flashCardFour = new FlashCard();
		flashCardFour.setCardId(1003);
		flashCardFour.setQuestion("What does EC2 stand for?");
		flashCardFour.setAnswer("Elastic Compute Cloud");
		Date currentDateTime4 = new Date();
		flashCardFour.setDateCreated(currentDateTime4);
		flashCardFour.setLastUpdated(currentDateTime4);
		flashCardRepo.save(flashCardFour);

		log.info("Saved Flash Card " + flashCardFour.getCardId());
	}

}