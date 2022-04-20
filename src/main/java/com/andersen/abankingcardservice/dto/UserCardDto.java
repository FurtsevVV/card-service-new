package com.andersen.abankingcardservice.dto;

import com.andersen.abankingcardservice.entity.CardStatus;
import com.andersen.abankingcardservice.entity.CardType;
import com.andersen.abankingcardservice.entity.Currency;
import com.andersen.abankingcardservice.entity.PaymantSystem;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class UserCardDto {

    private Long userId;
    private Long cardId;
    private CardType cardType;
    private PaymantSystem paymantSystem;
    private LocalDateTime validationPeriodDate;
    private String cardNumber;
    private BigDecimal balance;
    private Currency currency;
    private CardStatus cardStatus;


}
