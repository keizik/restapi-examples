package lt.keizik.restapi_examples.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lt.keizik.restapi_examples.models.Message;
import lt.keizik.restapi_examples.repositories.MessageRepository;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        var messages = new ArrayList<Message>();
        messageRepository.findAll().forEach(messages::add);
        return messages;
    }

    public Message createMessage(String message) {
        if (message == null) {
            throw new RuntimeException("message should not be null");
        }
        var messageModel = new Message();
        messageModel.setMessage(message);
        return messageRepository.save(messageModel);
    }

    public Message updateMessage(String id, List<String> messages) {
        if (messages.size() < 2) {
            throw new RuntimeException("at least 2 messages should be available");
        }

        var message = messageRepository.findById(Long.valueOf(id));
        if (message.isPresent()) {
            var messageModel = message.get();
            messageModel.setMessage(messages.get(1));
            return messageRepository.save(messageModel);
        }
        throw new RuntimeException(String.format("Message with id {} not found", id));
    }

    public Message deleteMessage(Long id) {
        var message = messageRepository.findById(id);
        if (message.isPresent()) {
            messageRepository.delete(message.get());
            return message.get();
        }
        throw new RuntimeException(String.format("Message with id {} not found", id));
    }

}
