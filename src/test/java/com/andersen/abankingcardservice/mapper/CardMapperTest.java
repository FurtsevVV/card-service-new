package com.andersen.abankingcardservice.mapper;

import com.andersen.abankingcardservice.InitDataForTest;
import com.andersen.abankingcardservice.dto.CardIdAccountDto;
import com.andersen.abankingcardservice.dto.UserCardDto;
import com.andersen.abankingcardservice.entity.Card;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardMapperTest {

    private final UserCardMapper cardMapper = Mappers.getMapper(UserCardMapper.class);

    @Test
    void mappingToUserCardDtoTest() {
        UserCardDto expectedDto = InitDataForTest.getUserCardDto1();
        Card card = InitDataForTest.getCardEntity1();
        UserCardDto actualMappedDto = cardMapper.toUserCardDto(card);

        assertEquals(expectedDto, actualMappedDto);
    }

    @Test
    void mappingToCardIdAccountDtoTest() {
        CardIdAccountDto expectedDto = InitDataForTest.getCardIdAccountDto1();
        Card card = InitDataForTest.getCardEntity1();
        CardIdAccountDto actualMappedDto = cardMapper.toCardIdAccountDto(card);

        assertEquals(expectedDto, actualMappedDto);
    }


}
