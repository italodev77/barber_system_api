package dev.mivas.BarberSystem.HaircutStyles.services;

import dev.mivas.BarberSystem.HaircutStyles.entity.HaircutModel;
import dev.mivas.BarberSystem.HaircutStyles.repository.HaircutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HaircutServices {
    private final HaircutRepository haircutRepository;


    public HaircutModel createHaircut(HaircutModel haircut) {
        return haircutRepository.save(haircut);
    }


    public HaircutModel updateHaircut(Long id, HaircutModel updatedHaircut) {

        HaircutModel existingHaircut = haircutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Corte de cabelo não encontrado"));


        existingHaircut.setName(updatedHaircut.getName());
        existingHaircut.setPrice(updatedHaircut.getPrice());
        existingHaircut.setStatus(updatedHaircut.getStatus());

        return haircutRepository.save(existingHaircut);
    }


    public void deleteHaircut(Long id) {
        HaircutModel haircut = haircutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Corte de cabelo não encontrado"));

        haircutRepository.delete(haircut);
    }


    public List<HaircutModel> listAllHaircuts() {
        return haircutRepository.findAll();
    }
}

