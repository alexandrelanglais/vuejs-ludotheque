package fr.demandeatonton.vuejs.ludotheque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Game;
import fr.demandeatonton.vuejs.ludotheque.services.GameService;

@Controller
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

}
