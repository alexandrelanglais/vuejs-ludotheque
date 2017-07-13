package fr.demandeatonton.vuejs.ludotheque.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Game;
import fr.demandeatonton.vuejs.ludotheque.model.pojos.Genre;

public interface GamesRepository extends CrudRepository<Game, Long> {

   Optional<Game> findByName(String name);

   Iterable<Game> findByGenre(Genre genre);
}
