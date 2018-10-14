package com.casino.blackjack.domain;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Deck of cards.
 */
public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    /**
     * @return a card from the deck
     */
    public List<Card> getCards() {
        return ImmutableList.copyOf(cards);
    }


    /**
     * Shuffle cards in the deck using Knuth's shuffle algorithm.
     */
    public void shuffle() {
        Random rand = ThreadLocalRandom.current();

        int n = cards.size();

        for (int i = n - 1; i >= 1; i--) {
            int j = rand.nextInt(i + 1);
            Collections.swap(cards, i, j);
        }
    }

    /**
     * @return a card if not empty
     */
    public Optional<Card> dealOneCard() {
        if (cards.size() == 0) {
            return Optional.empty();
        }

        return Optional.of(cards.remove(0));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Deck deck = (Deck) o;

        return Objects.equals(cards, deck.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}
