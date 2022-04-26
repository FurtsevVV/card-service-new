package com.andersen.abankingcardservice.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_generator")
    @SequenceGenerator(allocationSize = 1, name = "card_generator")
    private Long cardId;

    private Long userId;

    private Long accountId;

    private String cardNumber;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private LocalDateTime validationPeriodDate;

    private String cvv;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Enumerated(EnumType.STRING)
    private PaymantSystem paymantSystem;

    @ManyToOne
    private CreditCardProduct creditCardProduct;

    @ManyToOne
    private DebitCardProduct debitCardProduct;
}
