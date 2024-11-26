package org.khail.virementservice.Entitie;

import jakarta.persistence.*;
import lombok.*;
import org.khail.virementservice.Model.Benificiary;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString

public class Virement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double montant;
    private String description;
    private String date;
    private TypeVirement type;
    private Long beneficiaireId;
    private String ribSource;
    @Transient
    private Benificiary benificiary;
}
