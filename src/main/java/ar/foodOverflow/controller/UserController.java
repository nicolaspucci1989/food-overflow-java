package ar.foodOverflow.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

    @GetMapping("/user")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok("todo ok");
    }
}
