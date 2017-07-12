package fr.demandeatonton.vuejs.ludotheque.controllers;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Game;
import fr.demandeatonton.vuejs.ludotheque.model.pojos.Genre;
import fr.demandeatonton.vuejs.ludotheque.services.GameService;

@RunWith(SpringRunner.class)
@WebMvcTest(GamesController.class)
public class GameControllerTest {
   @Autowired
   private MockMvc mockMvc;

   @MockBean
   GameService gameServiceMock;

   @Autowired
   ObjectMapper objectMapper;

   @Test
   public void testCreateGameSuccessfully() throws Exception {
      given(gameServiceMock.createGame("GTA", "Action")).willReturn(new Game("GTA", new Genre("Action")));

      mockMvc.perform(post("/games/add")
            .contentType(MediaType.APPLICATION_JSON)
            .param("gameName", "GTA")
            .param("genreId", "0")
            .content(objectMapper.writeValueAsString(new CreateGameRequest("GTA", 0L))))
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.name", is("GTA")))
            .andExpect(jsonPath("$.id", notNullValue()));
   }
}