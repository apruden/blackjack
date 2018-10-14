package com.casino.blackjack.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CardTests {

    @Test
    public void testEquals() {
        Card thiz = new Card(Rank.Ace, Suit.Spades);
        Card that = new Card(Rank.Ace, Suit.Spades);
        Card other = new Card(Rank.Queen, Suit.Hearts);

        assertEquals(thiz, that);
        assertEquals(thiz.hashCode(), that.hashCode());
        assertNotEquals(thiz, other);
    }
}
