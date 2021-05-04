package dev.butane.oom.oombackend.controllers;

import dev.butane.oom.oombackend.controllers.DeckController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/*@WebMvcTest
public class DeckControllerSpec {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DeckController deckController;

    @Test
    void decksShouldReturnListOfDecks() throws Exception {
        deckController.getDecks();
        this.mockMvc.perform(MockMvcRequestBuilders.get("/decks"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[]"));

    }
} */
