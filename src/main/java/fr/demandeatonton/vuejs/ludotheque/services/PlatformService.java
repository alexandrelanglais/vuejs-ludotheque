package fr.demandeatonton.vuejs.ludotheque.services;

import org.springframework.stereotype.Service;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Platform;

@Service
public interface PlatformService {
   Platform createPlatform(String name, String constructor);

   Platform findByName(String name);

   Iterable<Platform> list();
}
