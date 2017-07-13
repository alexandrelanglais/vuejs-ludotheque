package fr.demandeatonton.vuejs.ludotheque.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Platform;

public interface PlatformRepository extends CrudRepository<Platform, Long> {

   Optional<Platform> findByName(String name);

}
