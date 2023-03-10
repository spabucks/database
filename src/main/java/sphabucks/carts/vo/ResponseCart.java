package sphabucks.carts.vo;

import lombok.*;
import org.springframework.stereotype.Service;
import sphabucks.carts.model.Cart;
import sphabucks.products.model.BigCategory;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ResponseCart {
    private Long categoryId;
    private List<Cart> cartList;
}
