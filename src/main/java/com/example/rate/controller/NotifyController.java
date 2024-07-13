package com.example.rate.controller;
import com.example.rate.services.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class NotifyController {
    NotificationService notificationService;
    @PostMapping("/sendNotify")
    public String sendNotification(@RequestBody String type, @RequestBody String message) {
        notificationService.setNotify(type, message);
        return ResponseEntity.ok().toString();
    }
}
