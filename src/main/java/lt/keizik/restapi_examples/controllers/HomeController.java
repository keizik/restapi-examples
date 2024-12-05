package lt.keizik.restapi_examples.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public String getHomePage() {
        return "This is home page";
    }

    // POST
    @PostMapping
    public String create() {
        return "Something was created";
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
