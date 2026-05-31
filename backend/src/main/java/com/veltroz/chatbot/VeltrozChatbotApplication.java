package com.veltroz.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.veltroz.chatbot"}) 
public class VeltrozChatbotApplication {
    public static void main(String[] args) {
        SpringApplication.run(VeltrozChatbotApplication.class, args);
    }
}
