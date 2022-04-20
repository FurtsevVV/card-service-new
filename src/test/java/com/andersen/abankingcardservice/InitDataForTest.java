package com.andersen.abankingcardservice;

import com.andersen.abankingcardservice.dto.CardIdAccountDto;
import com.andersen.abankingcardservice.dto.UserCardDto;
import com.andersen.abankingcardservice.entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InitDataForTest {

    public static Card getCardEntity1() {
        return Card.builder()
                .cardId(1L)
                .userId(1L)
                .accountId(1L)
                .balance(BigDecimal.valueOf(300000))
                .currency(Currency.RUSSIAN_RUBLE)
                .cardNumber("4500 0000 0000 0000")
                .cardStatus(CardStatus.ACTIVE)
                .cardType(CardType.DEBIT_CARD)
                .cvv("900")
                .paymantSystem(PaymantSystem.VISA)
                .validationPeriodDate(LocalDateTime.parse("2022-04-15T12:16:03.000000"))
                .build();
    }

    public static Card getCardEntity2() {
        return Card.builder()
                .cardId(2L)
                .userId(1L)
                .balance(BigDecimal.valueOf(20000))
                .currency(Currency.RUSSIAN_RUBLE)
                .cardNumber("4500 0000 0000 0002")
                .cardStatus(CardStatus.ACTIVE)
                .cardType(CardType.DEBIT_CARD)
                .cvv("990")
                .paymantSystem(PaymantSystem.VISA)
                .validationPeriodDate(LocalDateTime.parse("2022-07-15T12:16:03.000000"))
                .build();
    }

    public static UserCardDto getUserCardDto1() {
        return UserCardDto.builder()
                .cardId(1L)
                .userId(1L)
                .balance(BigDecimal.valueOf(300000))
                .currency(Currency.RUSSIAN_RUBLE)
                .cardNumber("4500 0000 0000 0000")
                .cardStatus(CardStatus.ACTIVE)
                .cardType(CardType.DEBIT_CARD)
                .validationPeriodDate(LocalDateTime.parse("2022-04-15T12:16:03.000000"))
                .paymantSystem(PaymantSystem.VISA)
                .build();
    }

    public static UserCardDto getUserCardDto2() {
        return UserCardDto.builder()
                .cardId(2L)
                .userId(1L)
                .balance(BigDecimal.valueOf(20000))
                .currency(Currency.RUSSIAN_RUBLE)
                .cardNumber("4500 0000 0000 0002")
                .cardStatus(CardStatus.ACTIVE)
                .cardType(CardType.DEBIT_CARD)
                .validationPeriodDate(LocalDateTime.parse("2022-07-15T12:16:03.000000"))
                .paymantSystem(PaymantSystem.VISA)
                .build();
    }

    public static CardIdAccountDto getCardIdAccountDto1() {
        return CardIdAccountDto.builder()
                .accountId(1L)
                .userId(1L)
                .cardNumber("4500 0000 0000 0000")
                .validationPeriodDate(LocalDateTime.parse("2022-04-15T12:16:03.000000"))
                .build();
    }

}
