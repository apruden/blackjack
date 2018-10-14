package com.casino.blackjack.web;

import com.casino.blackjack.domain.Card;
import com.casino.blackjack.domain.Rank;
import com.casino.blackjack.domain.Suit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DeckController.class)
public class DeckControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeckService deckService;

    @Test
    public void testShuffle() throws Exception {
        doNothing().when(deckService).shuffle();
        mockMvc.perform(post("/deck/_shuffle")).andExpect(status().isOk());
    }

    @Test
    public void testDealOne() throws Exception {
        when(deckService.dealOneCard()).thenReturn(new Card(Rank.Ace, Suit.Spades));
        mockMvc.perform(post("/deck/_deal_one_card")).andExpect(status().isOk())
                .andExpect(jsonPath("$.rank", is("Ace")))
                .andExpect(jsonPath("$.suit", is("Spades")));
    }
}
