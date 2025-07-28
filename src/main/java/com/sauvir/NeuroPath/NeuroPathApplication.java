package com.sauvir.NeuroPath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import com.sauvir.NeuroPath.EmailConfigurations.Email;

@SpringBootApplication(scanBasePackages = "com.sauvir.NeuroPath")
public class NeuroPathApplication {


	@Autowired
	private Email senderService;


	public static void main(String[] args) {
		SpringApplication.run(NeuroPathApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		senderService.sendEmail("2023kucp1130@iiitkota.ac.in","This is subject","This is body");
	}

}
