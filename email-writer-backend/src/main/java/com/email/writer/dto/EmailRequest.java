package com.email.writer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailRequest {

    private String emailContent;
    private String tone;

}
