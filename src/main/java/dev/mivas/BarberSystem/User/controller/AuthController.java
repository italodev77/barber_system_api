package dev.mivas.BarberSystem.User.controller;

import dev.mivas.BarberSystem.Config.TokenService;
import dev.mivas.BarberSystem.Mapper.UsersMapper;
import dev.mivas.BarberSystem.User.entity.UsersModel;
import dev.mivas.BarberSystem.User.request.LoginRequest;
import dev.mivas.BarberSystem.User.request.UsersRequest;
import dev.mivas.BarberSystem.User.response.LoginResponse;
import dev.mivas.BarberSystem.User.response.UsersResponse;
import dev.mivas.BarberSystem.User.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barber/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsersService usersService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UsersResponse> Register(@RequestBody UsersRequest request){
        UsersModel savedUser = usersService.save(UsersMapper.toUsers(request));
        return ResponseEntity.status(HttpStatus.CREATED).body((UsersMapper.toUsersResponse(savedUser)));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authenticate = authenticationManager.authenticate(userAndPass);

        UsersModel user = (UsersModel) authenticate.getPrincipal();

        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token));

    }
}
