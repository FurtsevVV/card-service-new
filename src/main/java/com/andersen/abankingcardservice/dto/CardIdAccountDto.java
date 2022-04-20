package com.andersen.abankingcardservice.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CardIdAccountDto {

    private Long userId;
    private LocalDateTime validationPeriodDate;
    private String cardNumber;
    private Long accountId;

}
