package sphabucks.payments.gifticons.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sphabucks.users.model.User;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GiftIconList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private GiftIcon giftIcon;
}
