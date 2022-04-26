package com.andersen.abankingcardservice.mapper;

import com.andersen.abankingcardservice.dto.CardIdAccountDto;
import com.andersen.abankingcardservice.dto.UserCardDto;
import com.andersen.abankingcardservice.dto.request.CreateNewCardDto;
import com.andersen.abankingcardservice.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserCardMapper {

    UserCardMapper INSTANCE = Mappers.getMapper(UserCardMapper.class);

    UserCardDto toUserCardDto(Card card);

    CardIdAccountDto toCardIdAccountDto(Card card);

    List<UserCardDto> toListUserCardDto(List<Card> cardList);

    Card toCardFromCreateNewCardDto(CreateNewCardDto newCardDto);
}
