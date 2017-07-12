package fr.demandeatonton.vuejs.ludotheque.model.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genre implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;

   @Column(nullable = false)
   private String name;

   public Genre() {
   }

   public Genre(Long id, String name) {
      super();
      this.id = id;
      this.name = name;
   }

   public Genre(String name) {
      this.name = name;
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

   @Override
   public String toString() {
      return "Genre [id=" + id + ", name=" + name + "]";
   }

}
