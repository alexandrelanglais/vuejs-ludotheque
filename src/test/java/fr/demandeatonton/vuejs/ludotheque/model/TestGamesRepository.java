package fr.demandeatonton.vuejs.ludotheque.model;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Game;
import fr.demandeatonton.vuejs.ludotheque.model.pojos.Genre;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestGamesRepository {

   @Autowired
   private TestEntityManager entityManager;

   @Autowired
   private GamesRepository gamesRepository;

   @Test
   public void testFindByName() {
      Genre genre = entityManager.persist(new Genre("Action"));
      entityManager.persist(new Game("GTA", genre));
      Optional<Game> game = gamesRepository.findByName("GTA");
      assertEquals("GTA", game.get().getName());
   }
}
