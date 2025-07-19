package com.email.writer.controller;


import com.email.writer.dto.EmailRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/do-request-email-content")
public class EmailRequestController {

    @PostMapping()
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
        return new ResponseEntity<>("sjj", HttpStatus.OK);
    }
}
