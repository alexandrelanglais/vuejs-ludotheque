package fr.demandeatonton.vuejs.ludotheque.services;

import org.springframework.stereotype.Service;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Game;
import fr.demandeatonton.vuejs.ludotheque.model.pojos.Genre;

@Service
public interface GameService {
   Game createGame(String gameName, String genreName);

   Game createGame(String gameName, Long genreId);

   Genre createGenre(String genreName);

   Game findByName(String gameName);

   Iterable<Game> listGames();
}
