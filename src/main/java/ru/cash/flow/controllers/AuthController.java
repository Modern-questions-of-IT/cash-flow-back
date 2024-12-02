package ru.cash.flow.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cash.flow.dto.JwtAuthenticationResponse;
import ru.cash.flow.dto.SignInRequest;
import ru.cash.flow.dto.SignUpRequest;
import ru.cash.flow.exceptions.UserUsernameAlreadyExistsException;
import ru.cash.flow.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Регистрация пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешная регистрация", content = @Content(schema = @Schema(implementation = JwtAuthenticationResponse.class))),
            @ApiResponse(responseCode = "400", description = "Неверный запрос", content = @Content(schema = @Schema(implementation = BadCredentialsException.class))),
            @ApiResponse(responseCode = "409", description = "Пользователь с таким именем уже существует", content = @Content(schema = @Schema(implementation = UserUsernameAlreadyExistsException.class)))
    })
    @PostMapping("/sign-up")
    public ResponseEntity<JwtAuthenticationResponse> signUp(@RequestBody @Valid SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signUp(request));
    }

    @Operation(summary = "Авторизация пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешная авторизация", content = @Content(schema = @Schema(implementation = JwtAuthenticationResponse.class))),
            @ApiResponse(responseCode = "400", description = "Неверные учетные данные", content = @Content(schema = @Schema(implementation = BadCredentialsException.class))),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден", content = @Content(schema = @Schema(implementation = UsernameNotFoundException.class)))
    })
    @PostMapping("/sign-in")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody @Valid SignInRequest request) {
        return ResponseEntity.ok(authenticationService.signIn(request));
    }

}
