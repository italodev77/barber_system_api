package dev.mivas.BarberSystem.HaircutStyles.repository;

import dev.mivas.BarberSystem.HaircutStyles.entity.HaircutModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HaircutRepository extends JpaRepository<HaircutModel, Long> {
}
