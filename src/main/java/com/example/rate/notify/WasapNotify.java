package com.example.rate.notify;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

@Service
public class WasapNotify implements Notification {

    private final RestClient restClient;

    public WasapNotify() {
        String urlApiMeta = "https://graph.facebook.com/v19.0/363190373546240/messages";
        restClient = RestClient.builder()
                .baseUrl(urlApiMeta)
                .defaultHeader("Authorization","Bearer EAAYCDUEuWicBOw941PpYxLFFgQnMvzFpwXmROyM6iUZCIfrxLgEZBwFGUNXFtGZApXvfw23H23P5xs276iEMZC8l49Oi76PASWTWlUlXw4lOpgdRaYpJg6gJDvp73s961h4kyULRwoEiu6yIBLnxZBnFj58KsD4BQkie0WEWpfMijZAib7ywZB71tGGIzGUdkiIqzzkh6v1i99nMR0hJgZDZD")
                .build();
    }
    @Override
    public void send(String receiver) {
            RequestMessageW requestMessageW = new RequestMessageW("whatsapp",receiver,new RequestMessageText("Hola un Saludo Especial te Invito A visualizar Este Codigo de Aprendisake"));
            try {
                String result = restClient.post()
                        .uri("")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(requestMessageW)
                        .retrieve()
                        .body(String.class);
            } catch (RestClientException ex) {
                throw  new RestClientResponseException("Error Send Message",400,"",null,null,null);
            }

    }
}
