package fr.demandeatonton.vuejs.ludotheque.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.demandeatonton.vuejs.ludotheque.exceptions.InvalidGenreCreationException;
import fr.demandeatonton.vuejs.ludotheque.model.PlatformRepository;
import fr.demandeatonton.vuejs.ludotheque.model.pojos.Platform;

@Service
public class PlatformServiceImpl implements PlatformService {
   @Autowired
   private PlatformRepository repository;

   @Override
   public Platform createPlatform(String name, String constructor) {
      Optional<Platform> platform = repository.findByName(name);
      if (platform.isPresent())
         throw new InvalidGenreCreationException("Platform already exists: " + name);
      Platform save = repository.save(new Platform(name, constructor));
      return save;
   }

   @Override
   public Platform findByName(String name) {
      Optional<Platform> platform = repository.findByName(name);
      return platform.get();
   }

   @Override
   public Iterable<Platform> list() {
      return repository.findAll();
   }

}
