package dev.mivas.BarberSystem.User.services;

import dev.mivas.BarberSystem.User.entity.UsersModel;
import dev.mivas.BarberSystem.User.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    public UsersModel save(UsersModel user){

        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return usersRepository.save(user);
    }

}
