package lt.keizik.restapi_examples.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lt.keizik.restapi_examples.dto.Message;
import lt.keizik.restapi_examples.dto.MessageForm;
import lt.keizik.restapi_examples.dto.MessageUpdateForm;

@RestController
@Tag(name = "Home Page")
public class HomeController {
    @GetMapping
    @Operation(description = "Home page info", summary = "Home page info")
    public String getHomePage() {
        return "This is home page";
    }

    // POST
    @PostMapping
    @Operation(description = "Create a message", summary = "Create a message")
    public Message create(@RequestBody MessageForm form) {
        return new Message(1L, form.getMessage());
    }
    
    // PUT
    @PutMapping("/{id}")
    @Operation(description = "Update a message", summary = "Update a message")
    public Message update(@PathVariable String id, @RequestBody MessageUpdateForm form) {
        var message = new Message(Long.valueOf(id), "Old message");
        message.setResponse(form.getMessages().get(1));
        return message;
    }
    
    // DELETE
    @DeleteMapping("/{id}")
    @Operation(description = "Delete a message", summary = "Delete a message")
    public Message delete(@PathVariable @Parameter(description = "Id of a message", example = "1") Long id) {
        return new Message(id, "Deleted");
    }
}
