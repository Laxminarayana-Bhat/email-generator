package com.email.writer.service;


import com.email.writer.dto.EmailRequest;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class EmailRequestAndResponseService {

    @Value("${g.key}")
    private String key;

    public String generateEmailReply(EmailRequest emailRequest) {
        //generate prompt to pass
        String prompt = generatePromptFromInput(emailRequest);
        //craft a request
        return geminiApiCall(prompt);
    }

    private String geminiApiCall(String prompt) {
        Client client = Client.builder().apiKey(key).build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        prompt,
                        null);

        return response.text();
    }


    private String generatePromptFromInput(EmailRequest emailRequest) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Generate a professional email reply for the following email content. Please dont generate the subject line");
        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            stringBuilder.append("Use a ").append(emailRequest.getTone()).append(" Tone");
        }
        stringBuilder.append("\nOriginal email content:\n").append(emailRequest.getEmailContent());
        return stringBuilder.toString();
    }


}
