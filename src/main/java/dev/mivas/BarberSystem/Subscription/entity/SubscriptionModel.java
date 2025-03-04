package dev.mivas.BarberSystem.Subscription.entity;

import dev.mivas.BarberSystem.User.entity.UsersModel;
import dev.mivas.BarberSystem.Subscription.enums.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionStatus status;

    @Column(nullable = false, unique = true)
    private String priceId;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private UsersModel user; // Relacionamento com o usuário
}
