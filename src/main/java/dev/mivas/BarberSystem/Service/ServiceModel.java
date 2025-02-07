package dev.mivas.BarberSystem.Service;

import dev.mivas.BarberSystem.Haircut.HaircutModel;
import dev.mivas.BarberSystem.User.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceModel {

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
    private UserModel user;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDateTime serviceDate;
}
