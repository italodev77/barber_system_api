package dev.mivas.BarberSystem.User.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(
        @NotEmpty(message = "E-mail obrigatório") String email,
        @NotEmpty(message = "Senha obrigatória") String password) {}
