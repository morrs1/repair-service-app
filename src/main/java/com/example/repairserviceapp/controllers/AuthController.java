package com.example.repairserviceapp.controllers;

import com.example.repairserviceapp.webToken.JwtService;
import com.example.repairserviceapp.webToken.LoginForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "Контроллер для аутентификации", description = "Здесь есть handlers для аутентификации")
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    private AuthenticationManager authenticationManager;

    private JwtService jwtService;

    private UserDetailsService userDetailsService;

    @Operation(
            summary = "Ручка для аутентификации",
            description = "Позволяет аутентифицировать пользователя, который уже был до этого зарегистрирован в ИС"
    )
    @PostMapping("/api/auth")
    public ResponseEntity<Map<String, String>> authenticateAndGetToken(@RequestBody LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginForm.username(), loginForm.password()
        ));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userDetailsService.loadUserByUsername(loginForm.username()));
        } else {
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }
}
