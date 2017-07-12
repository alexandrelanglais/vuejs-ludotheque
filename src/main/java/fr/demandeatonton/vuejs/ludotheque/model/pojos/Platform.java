package fr.demandeatonton.vuejs.ludotheque.model.pojos;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Platform implements Serializable {
   @Id
   @GeneratedValue
   private Long id;

   @Column(nullable = false)
   private String name;

   @Column(nullable = false)
   private String constructor;

   @ManyToMany
   private Set<Game> games;

   public Platform() {
   }

   public Platform(String name, String constructor, Set<Game> games) {
      this.name = name;
      this.constructor = constructor;
      this.games = games;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getConstructor() {
      return constructor;
   }

   public void setConstructor(String constructor) {
      this.constructor = constructor;
   }

   public Set<Game> getGames() {
      return games;
   }

   public void setGames(Set<Game> games) {
      this.games = games;
   }

   @Override
   public String toString() {
      return "Platform [id=" + id + ", name=" + name + ", constructor=" + constructor + "]";
   }

}
