package lt.keizik.restapi_examples.services;

import org.springframework.stereotype.Service;

import lt.keizik.restapi_examples.dto.Message;

@Service
public class MessageService {

    public Message createMessage(String message) {
        if (message == null) {
            throw new RuntimeException("message should not be null");
        }

        return new Message(1L, message);
    }

}
