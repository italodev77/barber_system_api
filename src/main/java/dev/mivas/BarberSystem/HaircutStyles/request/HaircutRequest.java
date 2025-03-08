package dev.mivas.BarberSystem.HaircutStyles.request;

import dev.mivas.BarberSystem.HaircutStyles.enums.HaircutStatus;
import dev.mivas.BarberSystem.User.entity.UsersModel;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public record HaircutRequest(
        @NotEmpty(message = "Nome do corte obrigatório") String name,
        @NotEmpty(message = "Preço obrigatório") BigDecimal price,
        @NotEmpty(message = "Status do estilo do corte é obrigatório") HaircutStatus status,
        UsersModel user) {}
