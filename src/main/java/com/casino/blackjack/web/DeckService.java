package com.casino.blackjack.web;

import com.casino.blackjack.domain.Card;
import com.casino.blackjack.domain.Deck;
import org.springframework.stereotype.Service;

@Service
public class DeckService {
    private Deck deck = new Deck();

    public synchronized Card dealOneCard() {
        return deck.dealOneCard().orElseThrow(EmptyDeckException::new);
    }

    public synchronized void shuffle() {
        deck.shuffle();
    }

    public synchronized void newDeck() {
        deck = new Deck();
    }

    static class EmptyDeckException extends RuntimeException { }
}
