package com.casino.blackjack.web;

import com.casino.blackjack.domain.Card;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deck")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @ApiOperation(value = "Deal one card from the deck.")
    @RequestMapping(path = "/_deal_one_card", method = RequestMethod.POST)
    public Card dealOneCard() {
        return deckService.dealOneCard();
    }

    @ApiOperation(value = "Shuffle cards in the deck.")
    @RequestMapping(path = "/_shuffle", method = RequestMethod.POST)
    public void shuffle() {
        deckService.shuffle();
    }

    @ApiOperation(value = "Creates a new deck.")
    @RequestMapping(path = "/_new", method = RequestMethod.POST)
    public void newDeck() {
        deckService.newDeck();
    }
}
