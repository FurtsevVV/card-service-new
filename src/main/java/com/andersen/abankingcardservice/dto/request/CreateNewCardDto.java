package com.andersen.abankingcardservice.dto.request;

import com.andersen.abankingcardservice.entity.CardType;
import com.andersen.abankingcardservice.entity.Currency;
import com.andersen.abankingcardservice.entity.PaymantSystem;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateNewCardDto {

    private Long userId;
    private Long accountId;
    private CardType cardType;
    private Currency currency;
    private PaymantSystem paymantSystem;



}
