package com.email.writer;

import com.email.writer.dto.EmailRequest;
import com.email.writer.service.EmailRequestAndResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailWriterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EmailWriterApplication.class, args);
    }

    @Autowired
    EmailRequestAndResponseService emailRequestAndResponseService;

    @Override
    public void run(String... args) throws Exception {
        //Testing with a dummy request
//		EmailRequest emailRequest= EmailRequest.builder().emailContent("Hi John,\n how are you doing?. what about the status of the project that we are making \n Regards,sam").build();
//		System.out.println(emailRequestAndResponseService.generateEmailReply(emailRequest));
    }
}
