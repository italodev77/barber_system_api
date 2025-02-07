package dev.mivas.BarberSystem.Haircut;

import dev.mivas.BarberSystem.User.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "haircuts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HaircutModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HaircutStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;
}
