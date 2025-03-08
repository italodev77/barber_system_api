package dev.mivas.BarberSystem.HaircutStyles.response;

import dev.mivas.BarberSystem.HaircutStyles.enums.HaircutStatus;
import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record HaircutResponse(Long id, String name, BigDecimal price, HaircutStatus status) {
}
