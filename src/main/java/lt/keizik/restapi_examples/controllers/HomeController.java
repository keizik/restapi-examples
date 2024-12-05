package lt.keizik.restapi_examples.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lt.keizik.restapi_examples.dto.CreatedMessage;
import lt.keizik.restapi_examples.dto.MessageForm;

@RestController
public class HomeController {
    @GetMapping
    public String getHomePage() {
        return "This is home page";
    }

    // POST
    @PostMapping
    public CreatedMessage create(@RequestBody MessageForm form) {
        return new CreatedMessage(1L, form.getMessage());
    }
    
    // PUT
    @PutMapping
    public String update() {
        return "Something was updated";
    }
    
    // DELETE
    @DeleteMapping
    public String delete() {
        return "Something was deleted";
    }
}
