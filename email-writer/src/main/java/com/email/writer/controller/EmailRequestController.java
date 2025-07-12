package com.email.writer.controller;


import com.email.writer.dto.EmailRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/v1/do-request-email-content")
public class EmailRequestController {

    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
        return new ResponseEntity<>("sjj", HttpStatus.OK);
    }
}
