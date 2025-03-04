package dev.mivas.BarberSystem.BarberShopServices.repository;

import dev.mivas.BarberSystem.BarberShopServices.entity.BarberShopServicesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberShopServicesRepository extends JpaRepository<BarberShopServicesModel, Long> {
}
