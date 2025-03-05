package dev.mivas.BarberSystem.User.request;

import jakarta.validation.constraints.NotEmpty;

public record UsersRequest(
        @NotEmpty(message = "O nome é obrigatório")
        String name,

        @NotEmpty(message = "O e-mail é obrigatório")
        String email,

        @NotEmpty(message = "A senha é obrigatória")
        String password
) {}

