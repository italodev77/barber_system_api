package dev.mivas.BarberSystem.HaircutStyles.controller;

import dev.mivas.BarberSystem.HaircutStyles.entity.HaircutModel;
import dev.mivas.BarberSystem.HaircutStyles.request.HaircutRequest;
import dev.mivas.BarberSystem.HaircutStyles.response.HaircutResponse;
import dev.mivas.BarberSystem.HaircutStyles.services.HaircutServices;
import dev.mivas.BarberSystem.Mapper.HaircutMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barber/haircuts")
@RequiredArgsConstructor
public class HaircutController {
    private final HaircutServices haircutServices;

    @PostMapping("/register")
    public ResponseEntity<HaircutResponse> Register(@Valid @RequestBody HaircutRequest haircutRequest){
        HaircutModel savedHaircut = haircutServices.createHaircut(HaircutMapper.toHaircut(haircutRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body((HaircutMapper.toHaircutResponse(savedHaircut)));
    }
}
