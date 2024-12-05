package lt.keizik.restapi_examples.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lt.keizik.restapi_examples.dto.Message;
import lt.keizik.restapi_examples.dto.MessageForm;
import lt.keizik.restapi_examples.dto.MessageUpdateForm;

@RestController
public class HomeController {
    @GetMapping
    public String getHomePage() {
        return "This is home page";
    }

    // POST
    @PostMapping
    public Message create(@RequestBody MessageForm form) {
        return new Message(1L, form.getMessage());
    }
    
    // PUT
    @PutMapping("/{id}")
    public Message update(@PathVariable String id, @RequestBody MessageUpdateForm form) {
        var message = new Message(Long.valueOf(id), "Old message");
        message.setResponse(form.getMessages().get(1));
        return message;
    }
    
    // DELETE
    @DeleteMapping("/{id}")
    public Message delete(@PathVariable Long id) {
        return new Message(id, "Deleted");
    }
}
