package fr.demandeatonton.vuejs.ludotheque.services;

import org.springframework.stereotype.Service;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Genre;

@Service
public interface GenreService {
   Genre createGenre(String genreName);

   Genre findByName(String genreName);

   Iterable<Genre> listGenres();
}
