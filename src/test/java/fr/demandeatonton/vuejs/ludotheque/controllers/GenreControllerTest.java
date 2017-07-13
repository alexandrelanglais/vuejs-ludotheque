package fr.demandeatonton.vuejs.ludotheque.controllers;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.demandeatonton.vuejs.ludotheque.TestBeans;
import fr.demandeatonton.vuejs.ludotheque.model.pojos.Genre;

@RunWith(SpringRunner.class)
@WebMvcTest(GenresController.class)
public class GenreControllerTest extends TestBeans {
   @Autowired
   private MockMvc mockMvc;

   @Autowired
   ObjectMapper mapper;

   public void addSomeGenres() throws Exception {
      given(genreServiceMock.createGenre("RPG")).willReturn(new Genre(1L,
            "RPG"));
      mockMvc.perform(post("/genres/add")
            .contentType(MediaType.APPLICATION_JSON)
            .param("genreName", "RPG"))
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.name", is("RPG")));

   }

   @Test
   public void canICreateGenre() throws Exception {
      given(genreServiceMock.createGenre("Adventure")).willReturn(new Genre(1L, "Adventure"));

      mockMvc.perform(post("/genres/add")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsBytes(new Genre(1L, "Adventure"))))
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.name", is("Adventure")))
            .andExpect(jsonPath("$.id", notNullValue()));

   }

   @Test
   public void canIListAllGenres() throws Exception {
      Set<Genre> tested = new HashSet<>();
      Genre genre = new Genre();
      genre.setName("RPG");
      tested.add(genre);

      given(genreServiceMock.listGenres()).willReturn(tested);

      mockMvc.perform(get("/genres/list")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].name", is("RPG")));
   }

}