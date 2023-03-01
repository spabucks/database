package sphabucks.event.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ResponseEventProduct {
    private Long eventId;
    private String eventName;
    private List<ResponseRecommendMD> responseRecommendMDList;
}