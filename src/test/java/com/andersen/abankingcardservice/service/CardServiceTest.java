package com.andersen.abankingcardservice.service;

import com.andersen.abankingcardservice.InitDataForTest;
import com.andersen.abankingcardservice.dto.UserCardDto;
import com.andersen.abankingcardservice.entity.Card;
import com.andersen.abankingcardservice.mapper.UserCardMapper;
import com.andersen.abankingcardservice.repository.CardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {


    @InjectMocks
    private CardServiceImpl cardService;

    @Mock
    private UserCardMapper cardMapper;

    @Mock
    private CardRepository cardRepository;

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


}
