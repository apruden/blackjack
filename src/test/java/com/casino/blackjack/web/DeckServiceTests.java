package com.casino.blackjack.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
public class DeckServiceTests {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public DeckService deckService() {
            return new DeckService();
        }
    }

    @Autowired
    private DeckService deckService;

    @Test
    public void testDealOneCard() {
        IntStream.range(0, 52).forEach(i -> deckService.dealOneCard());

        try {
            deckService.dealOneCard();
            fail("Dealt more than 52 cards");
        } catch (DeckService.EmptyDeckException ignored) {
        }
    }
}
