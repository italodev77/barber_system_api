package dev.mivas.BarberSystem.User.response;

import lombok.Builder;

@Builder
public record UsersResponse(Long id, String name, String email) {
}
