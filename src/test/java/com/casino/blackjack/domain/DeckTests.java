package com.casino.blackjack.domain;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class DeckTests {
    @Test
    public void testEquals() {
        Deck thiz = new Deck();
        Deck that = new Deck();

        assertEquals(thiz, that);
        assertEquals(thiz.hashCode(), that.hashCode());
    }

    @Test
    public void testShuffle() {
        Deck deck = new Deck();
        List<Card> orig = deck.getCards();
        deck.shuffle();
        List<Card> shuffled = deck.getCards();

        assertNotEquals(orig, shuffled);
    }

    @Test
    public void testDealLimit() {
        Deck deck = new Deck();

        for (int i = 0; i < 52; i++) {
            Optional<Card> optionalCard = deck.dealOneCard();
            assertTrue(optionalCard.isPresent());
        }

        Optional<Card> optionalCard = deck.dealOneCard();

        assertEquals(Optional.empty(), optionalCard);
    }
}
