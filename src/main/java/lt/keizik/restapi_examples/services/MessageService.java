package lt.keizik.restapi_examples.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lt.keizik.restapi_examples.models.Message;
import lt.keizik.restapi_examples.repositories.MessageRepository;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

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

        var message = messageRepository.findById(Long.valueOf(id));
        if (message.isPresent()) {
            var messageModel = message.get();
            messageModel.setMessage(messages.get(1));
            messageRepository.save(messageModel);
            return messageModel;
        } 
        throw new RuntimeException(String.format("Message with id {} not found", id));
    }

}
