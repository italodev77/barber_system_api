package dev.mivas.BarberSystem.User.repository;

import dev.mivas.BarberSystem.User.entity.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Long> {
    Optional<UserDetails> findByEmail(String email);
}
