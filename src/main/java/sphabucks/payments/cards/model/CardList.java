package sphabucks.payments.cards.model;

import jakarta.persistence.*;
import lombok.*;
import sphabucks.users.model.User;
import sphabucks.utility.BaseTimeEntity;

import java.util.Date;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardList extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    User user;

    @ManyToOne
    Card card;

    @Column(columnDefinition = "boolean default fault")
    private boolean isRepresent;
}
