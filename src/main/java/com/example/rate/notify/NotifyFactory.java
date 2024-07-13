package com.example.rate.notify;
import org.springframework.stereotype.Component;
@Component
public class NotifyFactory {
    public Notification createNotify ( String type ) {
        return switch (type) {
            case "EMAIL" -> new EmailNotify();
            case "WAP" -> new SmsNotify();
            case "SMS" -> new WasapNotify();
            default -> throw new IllegalArgumentException("Unknown notification type: " + type);
        };
    }
}
