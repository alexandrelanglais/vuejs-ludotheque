package fr.demandeatonton.vuejs.ludotheque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Genre;
import fr.demandeatonton.vuejs.ludotheque.services.GenreService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/genres")
public class GenresController {
   @Autowired
   private GenreService genreService;

   @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
   public @ResponseBody Genre createGenre(@RequestBody(required = true) Genre genre) {
      Genre createGenre = genreService.createGenre(genre.getName());
      return createGenre;
   }

   @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
   public @ResponseBody Iterable<Genre> listGenres() {
      return genreService.listGenres();
   }

}
