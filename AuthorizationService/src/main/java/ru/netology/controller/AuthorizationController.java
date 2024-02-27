package ru.netology.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.netology.Authorities;
import ru.netology.repository.User;
import ru.netology.service.AuthorizationService;
import ru.netology.exception.InvalidCredentials;
import ru.netology.exception.UnauthorizedUser;

import java.util.List;

@RestController
public class AuthorizationController {

    AuthorizationService service;
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }
    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user.getLogin(), user.getPassword());
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        System.out.println("[unauthorizedUserHandler] " + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}




