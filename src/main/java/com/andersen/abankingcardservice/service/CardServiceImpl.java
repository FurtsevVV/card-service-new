package com.andersen.abankingcardservice.service;

import com.andersen.abankingcardservice.dto.CardIdAccountDto;
import com.andersen.abankingcardservice.dto.UserCardDto;
import com.andersen.abankingcardservice.entity.Card;
import com.andersen.abankingcardservice.mapper.UserCardMapper;
import com.andersen.abankingcardservice.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final UserCardMapper cardMapper;


    public List<UserCardDto> getAllUserCards(Long userId) {
        List<Card> listUserCards = cardRepository.findAllByUserId(userId);
        log.info("=== getAllUserCards() get card entity's: " + listUserCards.size());
        return cardMapper.toListUserCardDto(listUserCards);
    }


    public CardIdAccountDto getCardIdAccountDto(Long cardId) {
        Card card = cardRepository.getById(cardId);
        log.info("=== getCardIdAccountDto() get card entity: " + card);
        return cardMapper.toCardIdAccountDto(card);
    }
}
