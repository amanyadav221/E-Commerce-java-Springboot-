package com.e_mart.Controller.Public;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_mart.DTO.NewsletterDTO;
import com.e_mart.Service.NewsletterService;

@RestController
@RequestMapping("/public/newsletter")
public class NewsletterPublicAPI {

    @Autowired
    private NewsletterService newsService;

    @PostMapping("/create")
    public ResponseEntity<?> createPublicNewsletter(@RequestBody NewsletterDTO letter) {
        if (letter == null || letter.getEmail() == null || letter.getEmail().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required!");
        }
        String result = newsService.createNewsletter("guest", letter.getEmail());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }
}
