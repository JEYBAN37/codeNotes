package com.example.rate.services;
import com.example.rate.notify.Notification;
import com.example.rate.notify.NotifyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotifyFactory notifyFactory;
    @Autowired
    public NotificationService(NotifyFactory notifyFactory) {
        this.notifyFactory = notifyFactory;
    }
    public void setNotify(String type , String receiver){
        Notification notification = notifyFactory.createNotify(type);
        notification.send(receiver);
    }
}
