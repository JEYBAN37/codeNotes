package com.example.rate.notify;
public class EmailNotify implements Notification{
    @Override
    public void send(String receiver) {
        System.out.println("Sending SMS with message: " + receiver);
    }
}
