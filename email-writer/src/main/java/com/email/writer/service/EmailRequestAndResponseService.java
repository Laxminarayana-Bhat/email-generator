package com.email.writer.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class EmailRequestAndResponseService {

    @Value("${g.api}")
    private String url;

    @Value("${g.key}")
    private String key;


}
