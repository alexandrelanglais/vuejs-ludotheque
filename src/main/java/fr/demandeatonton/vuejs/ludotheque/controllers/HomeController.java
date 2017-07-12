package fr.demandeatonton.vuejs.ludotheque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
   @RequestMapping("/greetings")
   public String greetings(Model model) {
      return "greetings";
   }

}
