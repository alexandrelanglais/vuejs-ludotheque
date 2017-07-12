package fr.demandeatonton.vuejs.ludotheque.controllers;

public class CreateGameRequest {
   private String gameName;
   private Long genreId;

   public CreateGameRequest(String gameName, Long genreId) {
      this.gameName = gameName;
      this.genreId = genreId;
   }

   public String getGameName() {
      return gameName;
   }

   public void setGameName(String gameName) {
      this.gameName = gameName;
   }

   public Long getGenreId() {
      return genreId;
   }

   public void setGenreId(Long genreId) {
      this.genreId = genreId;
   }

}
