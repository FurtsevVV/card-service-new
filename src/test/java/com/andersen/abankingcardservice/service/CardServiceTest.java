package com.andersen.abankingcardservice.service;

import com.andersen.abankingcardservice.InitDataForTest;
import com.andersen.abankingcardservice.dto.UserCardDto;
import com.andersen.abankingcardservice.dto.request.CreateNewCardDto;
import com.andersen.abankingcardservice.entity.Card;
import com.andersen.abankingcardservice.entity.CardStatus;
import com.andersen.abankingcardservice.mapper.UserCardMapper;
import com.andersen.abankingcardservice.repository.CardRepository;
import com.andersen.abankingcardservice.validation.CardRequisitesGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
class CardServiceTest {


    @InjectMocks
    private CardServiceImpl cardService;

    @Mock
    private UserCardMapper cardMapper;

    @Mock
    private CardRepository cardRepository;

    @Mock
    private CardRequisitesGenerator requisitesGenerator;

     @Test
    void getAllUserCardsTest() {
        List<Card> expectedList = new ArrayList<>();
        expectedList.add(InitDataForTest.getCardEntity1());
        expectedList.add(InitDataForTest.getCardEntity2());

        List<UserCardDto> expectedDtoList = new ArrayList<>();
        expectedDtoList.add(InitDataForTest.getUserCardDto1());
        expectedDtoList.add(InitDataForTest.getUserCardDto2());

        when(cardRepository.findAllByUserId(any())).thenReturn(expectedList);
        when(cardMapper.toListUserCardDto(expectedList)).thenReturn(expectedDtoList);

        assertEquals(expectedDtoList, cardService.getAllUserCards(any()));
    }

    @Test
    void  createNewUserCardTest(){
         Card expectedCard = InitDataForTest.getCardEntity1();

         when(cardMapper.toUserCardDto(expectedCard)).thenReturn(InitDataForTest.getUserCardDto1());
         UserCardDto expectedResult = cardMapper.toUserCardDto(expectedCard);
        CreateNewCardDto createNewCardDto = InitDataForTest.getCreateNewCardDto1();
        Card actualCard = cardMapper.toCardFromCreateNewCardDto(createNewCardDto);
        log.info("actCard= " + actualCard);
        actualCard.setCardNumber("4500 0000 0000 0000");
        actualCard.setCardStatus(CardStatus.ACTIVE);
        actualCard.setBalance(BigDecimal.ZERO);
        actualCard.setCvv("900");
        actualCard.setValidationPeriodDate(LocalDateTime.parse("2022-04-15T12:16:03.000000"));

        Card savedCard = cardRepository.save(actualCard);

        assertEquals(expectedResult, cardService.createNewUserCard());
    }


}
