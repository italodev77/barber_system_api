package dev.mivas.BarberSystem.User;

import dev.mivas.BarberSystem.Haircut.HaircutModel;
import dev.mivas.BarberSystem.Subscription.SubscriptionModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String telefone;

    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private SubscriptionModel subscription;

    @OneToMany(mappedBy = "user")
    private List<HaircutModel> haircuts;
}
