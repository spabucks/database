package sphabucks.products.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseProductSummary {
    private Long id;
    private String title;
    private String imgUrl;
    private Integer price;
    private Boolean isNew;
}
