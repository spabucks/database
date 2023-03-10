package sphabucks.payments.cards.vo;

import lombok.Getter;

@Getter
public class RequestCard {
    private String name;    // 카드 이름
    private Integer defaultMoney;   // 카드 초기금액
    private String number;  // 카드 번호
    private String pin; // 핀번호(8자리)
    private String image;   // 카드 이미지 경로
    private Integer money;  // 현재 잔액
}
