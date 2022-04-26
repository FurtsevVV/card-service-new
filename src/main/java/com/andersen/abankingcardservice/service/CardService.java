package com.andersen.abankingcardservice.service;


import com.andersen.abankingcardservice.dto.CardIdAccountDto;
import com.andersen.abankingcardservice.dto.UserCardDto;
import com.andersen.abankingcardservice.dto.request.CreateNewCardDto;

import java.util.List;

public interface CardService {
    public CardIdAccountDto getCardIdAccountDto(Long cardId);

    List<UserCardDto> getAllUserCards(Long userId);

    UserCardDto createNewUserCard(CreateNewCardDto newCardDto);


}
