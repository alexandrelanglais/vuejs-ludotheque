package fr.demandeatonton.vuejs.ludotheque.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.demandeatonton.vuejs.ludotheque.exceptions.InvalidGenreException;
import fr.demandeatonton.vuejs.ludotheque.model.GamesRepository;
import fr.demandeatonton.vuejs.ludotheque.model.GenreRepository;
import fr.demandeatonton.vuejs.ludotheque.model.pojos.Game;
import fr.demandeatonton.vuejs.ludotheque.model.pojos.Genre;

@Service
public class GameServiceImpl implements GameService {
   @Autowired
   private GamesRepository gamesRepository;

   @Autowired
   private GenreRepository genresRepository;

   @Override
   public Game createGame(String gameName, String genreName) {
      Optional<Genre> genre = genresRepository.findByName(genreName);
      if (!genre.isPresent()) {
         Genre createdGenre = genresRepository.save(new Genre(genreName));
         genre = Optional.of(createdGenre);
      }
      Game game = new Game(gameName, genre.get());
      return gamesRepository.save(game);
   }

   @Override
   public Game createGame(String gameName, Long genreId) {
      Genre genre = genresRepository.findOne(genreId);
      if (genre == null)
         throw new InvalidGenreException("Genre not found: " + genreId);

      Game game = new Game(gameName, genre);

      return gamesRepository.save(game);
   }

   @Override
   public Game findByName(String gameName) {
      Optional<Game> game = gamesRepository.findByName(gameName);
      return game.get();
   }

   @Override
   public Iterable<Game> listGames() {
      return gamesRepository.findAll();
   }

}
