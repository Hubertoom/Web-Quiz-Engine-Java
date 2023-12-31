package engine.controller;

import engine.model.RegistrationRequest;
import engine.servis.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/api/register")
    ResponseEntity<?> registerNewUser(@Valid @RequestBody RegistrationRequest request) {
        registrationService.registerUser(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
