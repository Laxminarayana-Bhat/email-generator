package com.email.writer.controller;


import com.email.writer.dto.EmailRequest;
import com.email.writer.service.EmailRequestAndResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1")
public class EmailRequestController {

    private final EmailRequestAndResponseService emailRequestAndResponseService;

    EmailRequestController(EmailRequestAndResponseService emailRequestAndResponseService){
        this.emailRequestAndResponseService = emailRequestAndResponseService;
    }

    @PostMapping("/do-request-email-content")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
        return new ResponseEntity<>(emailRequestAndResponseService.generateEmailReply(emailRequest), HttpStatus.OK);
    }
}
