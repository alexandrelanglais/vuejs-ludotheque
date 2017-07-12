package fr.demandeatonton.vuejs.ludotheque.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

   Optional<Genre> findByName(String name);

}
