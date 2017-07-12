package fr.demandeatonton.vuejs.ludotheque.model.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Game implements Serializable {
   @Id
   @GeneratedValue
   private Long id;

   @Column(nullable = false)
   private String name;

   @Column
   private String description;

   @Column
   private Date launchDate;

   @ManyToOne
   private Genre genre;

   @ManyToMany
   private Set<Platform> platforms;

   public Game() {
   }

   public Game(String name, Genre genre) {
      this.name = name;
      this.genre = genre;
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

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Date getLaunchDate() {
      return launchDate;
   }

   public void setLaunchDate(Date launchDate) {
      this.launchDate = launchDate;
   }

   public Genre getGenre() {
      return genre;
   }

   public void setGenre(Genre genre) {
      this.genre = genre;
   }

   public Set<Platform> getPlatforms() {
      return platforms;
   }

   public void setPlatforms(Set<Platform> platforms) {
      this.platforms = platforms;
   }

   @Override
   public String toString() {
      return "Game [id=" + id + ", name=" + name + ", description=" + description + ", launchDate=" + launchDate
            + ", genre=" + genre + ", platforms=" + platforms + "]";
   }

}
