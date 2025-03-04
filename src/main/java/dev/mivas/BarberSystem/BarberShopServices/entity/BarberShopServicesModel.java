package dev.mivas.BarberSystem.BarberShopServices.entity;

import dev.mivas.BarberSystem.HaircutStyles.entity.HaircutModel;
import dev.mivas.BarberSystem.User.entity.UsersModel;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_barber_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BarberShopServicesModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String client;

        @ManyToOne
        @JoinColumn(name = "haircut_id", nullable = false)
        private HaircutModel haircut;

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private UsersModel user;

        @Column(nullable = false)
        private BigDecimal price;

        @Column(nullable = false)
        private LocalDateTime serviceDate;
}
