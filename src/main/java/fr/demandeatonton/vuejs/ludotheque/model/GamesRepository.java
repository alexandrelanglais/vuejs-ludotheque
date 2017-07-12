package fr.demandeatonton.vuejs.ludotheque.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Game;

public interface GamesRepository extends CrudRepository<Game, Long> {

   Optional<Game> findByName(String name);

}
