package fr.demandeatonton.vuejs.ludotheque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Game;
import fr.demandeatonton.vuejs.ludotheque.model.pojos.Genre;
import fr.demandeatonton.vuejs.ludotheque.services.GameService;

@RestController
@RequestMapping("/games")
public class GamesController {
   @Autowired
   private GameService gameService;

   @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
   public @ResponseBody Game create(@RequestParam(required = true) String gameName,
         @RequestParam(required = true) Long genreId) {
      Game createGame = gameService.createGame(gameName, genreId);
      return createGame;
   }

   @RequestMapping(value = "/addGenre", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
   public @ResponseBody Genre createGenre(@RequestParam(required = true) String genreName) {
      Genre createGenre = gameService.createGenre(genreName);
      return createGenre;
   }

   @RequestMapping(value = "/getByName", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
   public @ResponseBody Game getGameByName(@RequestParam(required = true) String gameName) {
      Game game = gameService.findByName(gameName);
      return game;
   }

   @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
   public @ResponseBody Iterable<Game> listGames() {
      return gameService.listGames();
   }

   @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
   public @ResponseBody Game test() {
      Game createGame = gameService.createGame("GTA", "Action");
      return createGame;
   }

}
