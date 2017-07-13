package fr.demandeatonton.vuejs.ludotheque;

import org.springframework.boot.test.mock.mockito.MockBean;

import fr.demandeatonton.vuejs.ludotheque.services.GameService;
import fr.demandeatonton.vuejs.ludotheque.services.GenreService;
import fr.demandeatonton.vuejs.ludotheque.services.PlatformService;

public class TestBeans {
   @MockBean
   protected GameService gameServiceMock;

   @MockBean
   protected GenreService genreServiceMock;

   @MockBean
   protected PlatformService platformServiceMock;

}
