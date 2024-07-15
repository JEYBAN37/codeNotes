package com.example.rate.notify;

public record RequestMessageW (
        String messaging_product,
        String to,
        RequestMessageText text

){}