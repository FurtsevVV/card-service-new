package com.andersen.abankingcardservice.controller;

import com.andersen.abankingcardservice.dto.CardIdAccountDto;
import com.andersen.abankingcardservice.dto.UserCardDto;
import com.andersen.abankingcardservice.dto.request.CreateNewCardDto;
import com.andersen.abankingcardservice.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final CardService cardService;


    @GetMapping("/card/{id}")
    public CardIdAccountDto getCardByCardId(@PathVariable Long id) {
        return cardService.getCardIdAccountDto(id);
    }

    @GetMapping("/list/{userId}")
    public List<UserCardDto> getAllUserCards(@PathVariable Long userId) {
        return cardService.getAllUserCards(userId);
    }

    @PostMapping("/card/save")
    public UserCardDto saveNewUserCard(@RequestBody CreateNewCardDto newCardDto){
        log.info("=== saveNewUserCard() get request: " + newCardDto);
        return cardService.createNewUserCard(newCardDto);
    }
}
