package br.edu.utfpr.pb.pw25s.serverproject.controller;

import br.edu.utfpr.pb.pw25s.serverproject.dto.Response.UserResponseDto;
import br.edu.utfpr.pb.pw25s.serverproject.model.User;
import br.edu.utfpr.pb.pw25s.serverproject.service.AuthService;
import br.edu.utfpr.pb.pw25s.serverproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }


    @GetMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void verifyToken() {
        authService.indetifyUser();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping
    public ResponseEntity<UserResponseDto> update(@RequestBody @Valid User user) {
        UserResponseDto account = userService.save(user);

        return ResponseEntity.ok(account);
    }
}
