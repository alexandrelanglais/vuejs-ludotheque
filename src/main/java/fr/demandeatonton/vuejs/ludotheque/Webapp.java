package fr.demandeatonton.vuejs.ludotheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "fr.demandeatonton.vuejs.ludotheque.controllers",
      "fr.demandeatonton.vuejs.ludotheque.services" })
@EntityScan("fr.demandeatonton.vuejs.ludotheque.model.pojos")
public class Webapp {

   public static void main(String[] args) {
      SpringApplication.run(Webapp.class, args);
   }
}