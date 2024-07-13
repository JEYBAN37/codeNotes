package com.example.rate.notify;
public class WasapNotify implements Notification {
    @Override
    public void send(String receiver) {
        System.out.println("Sending wasap with message: " + receiver);
    }
}
