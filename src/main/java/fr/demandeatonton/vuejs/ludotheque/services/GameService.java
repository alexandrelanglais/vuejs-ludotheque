package fr.demandeatonton.vuejs.ludotheque.services;

import org.springframework.stereotype.Service;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Game;

@Service
public interface GameService {
   Game createGame(String gameName, String genreName);

   Game createGame(String gameName, Long genreId);

   Game findByName(String gameName);

   Iterable<Game> listGames();
}
