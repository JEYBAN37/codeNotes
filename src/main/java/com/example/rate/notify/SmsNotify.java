package com.example.rate.notify;
import com.twilio.http.TwilioRestClient;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Service
public class SmsNotify implements Notification{
    private TwilioRestClient twilioRestClient;
    @Override
    public void send(String receiver) {
        Message.creator(
                new PhoneNumber(receiver),
                new PhoneNumber("3177722509"),"Hola un Saludo Especial te Invito A visualizar Este Codigo de Aprendisaje"
        ).create(twilioRestClient);
    }
}
