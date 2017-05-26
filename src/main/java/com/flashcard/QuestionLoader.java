package com.flashcard;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.flashcard.domain.FlashCard;
import com.flashcard.domain.Role;
import com.flashcard.domain.UserProfile;
import com.flashcard.repository.FlashCardRepository;
import com.flashcard.service.RoleService;
import com.flashcard.service.UserProfileService;

import java.util.Date;
import java.util.List;

@Component
public class QuestionLoader implements ApplicationListener<ContextRefreshedEvent> {

	private FlashCardRepository flashCardRepo;
	private UserProfileService userProfileService;
	private RoleService roleService;
	private Logger log = Logger.getLogger(QuestionLoader.class);

	@Autowired
	public void setProductRepository(FlashCardRepository flashCardRepo) {
		this.flashCardRepo = flashCardRepo;
	}
	
    @Autowired
    public void setUserProfileService(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		loadCategories();
//		loadQuestions();
//		loadUsers();
//		loadRoles();
//		assignUsersToUserRole();
//		assignUsersToAdminRole();
	}
	
//	private void loadCategoies() {	
//	}
	
	private void loadQuestions() {	
		FlashCard flashCardOne = new FlashCard();
		flashCardOne.setQuestion("What does EC2 stand for?");
		flashCardOne.setAnswer("Elastic Compute Cloud");
		Date currentDateTime = new Date();
		flashCardOne.setDateCreated(currentDateTime);
		flashCardOne.setLastUpdated(currentDateTime);
		flashCardRepo.save(flashCardOne);

		log.info("Saved Flash Card " + flashCardOne.getId());

		FlashCard flashCardTwo = new FlashCard();
		flashCardTwo.setQuestion("What are the 4 pricing options you have for EC2 instances?");
		flashCardTwo.setAnswer("On-demand, spot, reserved, dedicated hosts");
		Date currentDateTime2 = new Date();
		flashCardTwo.setDateCreated(currentDateTime2);
		flashCardTwo.setLastUpdated(currentDateTime2);
		flashCardRepo.save(flashCardTwo);

		log.info("Saved Flash Card " + flashCardTwo.getId());

		FlashCard flashCardThree = new FlashCard();
		flashCardThree.setQuestion("What are the 5 different volume types available for EBS?");
		flashCardThree.setAnswer("General Purpose SSD (GP2), Provisioned IOPS SSD (IO1)"
				+ "Throughput Optimized HDD (ST1), Cold HDD (SC1), Magnetic (Standard)");
		Date currentDateTime3 = new Date();
		flashCardThree.setDateCreated(currentDateTime3);
		flashCardThree.setLastUpdated(currentDateTime3);
		flashCardRepo.save(flashCardThree);

		log.info("Saved Flash Card " + flashCardThree.getId());

		FlashCard flashCardFour = new FlashCard();
		flashCardFour.setQuestion("What are the 4 routing options you have for Route 53");
		flashCardFour.setAnswer("Simple, weighted, Latency, Failover, Geolocation");
		Date currentDateTime4 = new Date();
		flashCardFour.setDateCreated(currentDateTime4);
		flashCardFour.setLastUpdated(currentDateTime4);
		flashCardRepo.save(flashCardFour);

		log.info("Saved Flash Card " + flashCardFour.getId());
	}
	
	private void loadUsers() {
		UserProfile user1 = new UserProfile();
		user1.setUsername("user");
		user1.setPassword("user");
		user1.setEmail("user@user.com");
		user1.setFirstName("User");
		user1.setLastName("Userson");
		userProfileService.saveOrUpdate(user1);
		
		UserProfile user2 = new UserProfile();
		user2.setUsername("admin");
		user2.setPassword("admin");
		user2.setEmail("admin@admin.com");
		user2.setFirstName("Admin");
		user2.setLastName("Administrator");
		userProfileService.saveOrUpdate(user2);
		
	}
	
	private void loadRoles() {
        Role role = new Role();
        role.setRole("USER");
        roleService.saveOrUpdate(role);
        log.info("Saved role " + role.getRole());
        
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        roleService.saveOrUpdate(adminRole);
        log.info("Saved role " + adminRole.getRole());
	}
	
    @SuppressWarnings("unchecked")
	private void assignUsersToUserRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<UserProfile> users = (List<UserProfile>) userProfileService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("USER")) {
                users.forEach(user -> {
                    if (user.getUsername().equals("user")) {
                        user.addRole(role);
                        userProfileService.saveOrUpdate(user);
                        log.info("Updated role for " + user.getUsername());
                    }
                });
            }
        });
    }
    
    @SuppressWarnings("unchecked")
	private void assignUsersToAdminRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<UserProfile> users = (List<UserProfile>) userProfileService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("ADMIN")) {
                users.forEach(user -> {
                    if (user.getUsername().equals("admin")) {
                        user.addRole(role);
                        userProfileService.saveOrUpdate(user);
                        log.info("Updated role for " + user.getUsername());
                        
                    }
                });
            }
        });
    }

}