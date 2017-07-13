package fr.demandeatonton.vuejs.ludotheque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Game;
import fr.demandeatonton.vuejs.ludotheque.services.GameService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/games")
public class GamesController {
   @Autowired
   private GameService gameService;

   @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
   public @ResponseBody Game create(@RequestBody(required = true) Game game) {
      Game createGame = gameService.createGame(game.getName(), game.getGenre().getId());
      return createGame;
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

}
