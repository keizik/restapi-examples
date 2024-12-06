package lt.keizik.restapi_examples.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lt.keizik.restapi_examples.models.Message;

@Service
public class MessageService {

    public Message createMessage(String message) {
        if (message == null) {
            throw new RuntimeException("message should not be null");
        }

        return new Message(1L, message);
    }

    public Message updateMessage(String id, List<String> messages) {
        if (messages.size() < 2) {
            throw new RuntimeException("at least 2 messages should be available");
        }

        var message = new Message(Long.valueOf(id), "Old message");
        message.setMessage(messages.get(1));
        return message;
    }

}
