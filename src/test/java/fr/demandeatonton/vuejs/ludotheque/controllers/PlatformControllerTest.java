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
import fr.demandeatonton.vuejs.ludotheque.model.pojos.Platform;

@RunWith(SpringRunner.class)
@WebMvcTest(PlatformsController.class)
public class PlatformControllerTest extends TestBeans {
   @Autowired
   private MockMvc mockMvc;

   @Autowired
   ObjectMapper mapper;

   @Test
   public void canICreatePlatform() throws Exception {
      given(platformServiceMock.createPlatform("PS3", "Sony")).willReturn(new Platform("PS3", "Sony"));

      mockMvc.perform(post("/platforms/add")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsBytes(new Platform("PS3", "Sony"))))
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.name", is("PS3")));

   }

   @Test
   public void canIListAllPlatforms() throws Exception {
      Set<Platform> tested = new HashSet<>();
      Platform platform = new Platform();
      platform.setName("PS3");
      platform.setConstructor("Sony");
      tested.add(platform);

      given(platformServiceMock.list()).willReturn(tested);

      mockMvc.perform(get("/platforms/list")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].name", is("PS3")));
   }

}