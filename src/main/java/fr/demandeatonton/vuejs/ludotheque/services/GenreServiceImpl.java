package fr.demandeatonton.vuejs.ludotheque.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.demandeatonton.vuejs.ludotheque.exceptions.InvalidGenreCreationException;
import fr.demandeatonton.vuejs.ludotheque.model.GenreRepository;
import fr.demandeatonton.vuejs.ludotheque.model.pojos.Genre;

@Service
public class GenreServiceImpl implements GenreService {
   @Autowired
   private GenreRepository genresRepository;

   @Override
   public Genre createGenre(String genreName) {
      Optional<Genre> genre = genresRepository.findByName(genreName);
      if (genre.isPresent())
         throw new InvalidGenreCreationException("Genre already exists: " + genreName);
      Genre save = genresRepository.save(new Genre(genreName));
      return save;
   }

   @Override
   public Genre findByName(String genreName) {
      Optional<Genre> genre = genresRepository.findByName(genreName);
      return genre.get();
   }

   @Override
   public Iterable<Genre> listGenres() {
      return genresRepository.findAll();
   }

}
