package tn.esprit.spring;


import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import tn.esprit.spring.services.EmailSenderService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;




@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
@Configuration
public class PidevSpringApplication {
	
	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(PidevSpringApplication.class, args);
	}

	
	

}




