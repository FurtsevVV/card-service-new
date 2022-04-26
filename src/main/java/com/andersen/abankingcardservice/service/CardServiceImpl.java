package com.andersen.abankingcardservice.service;

import com.andersen.abankingcardservice.dto.CardIdAccountDto;
import com.andersen.abankingcardservice.dto.UserCardDto;
import com.andersen.abankingcardservice.dto.request.CreateNewCardDto;
import com.andersen.abankingcardservice.entity.Card;
import com.andersen.abankingcardservice.entity.CardStatus;
import com.andersen.abankingcardservice.mapper.UserCardMapper;
import com.andersen.abankingcardservice.repository.CardRepository;
import com.andersen.abankingcardservice.validation.CardRequisitesGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final UserCardMapper cardMapper;
    private final CardRequisitesGenerator requisitesGenerator;


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

    /**
     * Method create new user card, generate card number, cvv and id.
     * Set validity period.
     *
     * @return new UserCardDto
     */
    public UserCardDto createNewUserCard(CreateNewCardDto newCardDto) {
        Card card = cardMapper.toCardFromCreateNewCardDto(newCardDto);
        card.setCardStatus(CardStatus.ACTIVE);
        card.setCvv(requisitesGenerator.generateCVV());
        card.setCardNumber(requisitesGenerator.generateCardNumber());
        card.setValidationPeriodDate(requisitesGenerator.setValidityPeriod());
        card.setBalance(BigDecimal.ZERO);

        Card savedCard = cardRepository.save(card);
        log.info("=== createNewUserCard() save entity: " + savedCard);
        return cardMapper.toUserCardDto(savedCard);

    }
}
