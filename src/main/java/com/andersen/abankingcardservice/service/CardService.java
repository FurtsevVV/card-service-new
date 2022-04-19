package com.andersen.abankingcardservice.service;


import com.andersen.abankingcardservice.dto.CardIdAccountDto;
import com.andersen.abankingcardservice.dto.UserCardDto;

import java.util.List;

public interface CardService {
    public CardIdAccountDto getCardIdAccountDto(Long cardId);

    List<UserCardDto> getAllUserCards(Long userId);
}
