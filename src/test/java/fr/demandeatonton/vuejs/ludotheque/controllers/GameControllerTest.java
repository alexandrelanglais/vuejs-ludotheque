package fr.demandeatonton.vuejs.ludotheque.controllers;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
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

   @Before
   public void addSomeGames() throws Exception {
      given(gameServiceMock.createGenre("RPG")).willReturn(new Genre(1L,
            "RPG"));
      mockMvc.perform(post("/games/addGenre")
            .contentType(MediaType.APPLICATION_JSON)
            .param("genreName", "RPG"))
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.name", is("RPG")));

      given(gameServiceMock.createGame("FFXV", 1L)).willReturn(new Game(1L, "FFXV", new Genre(1L, "RPG")));
      mockMvc.perform(post("/games/add")
            .contentType(MediaType.APPLICATION_JSON)
            .param("gameName", "FFXV")
            .param("genreId", "1"))
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.name", is("FFXV")));
   }

   @Test
   public void canICreateGenreAndGame() throws Exception {
      given(gameServiceMock.createGenre("Action")).willReturn(new Genre(1L,
            "Action"));

      mockMvc.perform(post("/games/addGenre")
            .contentType(MediaType.APPLICATION_JSON)
            .param("genreName", "Action"))
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.name", is("Action")))
            .andExpect(jsonPath("$.id", notNullValue()));

      given(gameServiceMock.createGame("GTA", 1L)).willReturn(new Game(1L, "GTA", new Genre(1L, "Action")));
      mockMvc.perform(post("/games/add")
            .contentType(MediaType.APPLICATION_JSON)
            .param("gameName", "GTA")
            .param("genreId", "1"))
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.name", is("GTA")))
            .andExpect(jsonPath("$.id", notNullValue()));
   }

   @Test
   public void canICreateGenre() throws Exception {
      given(gameServiceMock.createGenre("Adventure")).willReturn(new Genre(1L, "Adventure"));

      mockMvc.perform(post("/games/addGenre")
            .contentType(MediaType.APPLICATION_JSON)
            .param("genreName", "Adventure"))
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.name", is("Adventure")))
            .andExpect(jsonPath("$.id", notNullValue()));

   }

   @Test
   public void canIRetrieveAGame() throws Exception {
      Game tested = new Game();
      tested.setName("FFXV");
      given(gameServiceMock.findByName("FFXV")).willReturn(tested);

      mockMvc.perform(get("/games/getByName")
            .contentType(MediaType.APPLICATION_JSON)
            .param("gameName", "FFXV"))
            .andExpect(jsonPath("$.name", is("FFXV")));
   }

   @Test
   public void canIListAllGames() throws Exception {
      Set<Game> tested = new HashSet<>();
      Game game = new Game();
      game.setName("FFXV");
      tested.add(game);

      given(gameServiceMock.listGames()).willReturn(tested);

      mockMvc.perform(get("/games/list")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].name", is("FFXV")));
   }
}