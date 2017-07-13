package fr.demandeatonton.vuejs.ludotheque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.demandeatonton.vuejs.ludotheque.model.pojos.Platform;
import fr.demandeatonton.vuejs.ludotheque.services.PlatformService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/platforms")
public class PlatformsController {
   @Autowired
   private PlatformService platformService;

   @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
   public @ResponseBody Platform createPlatform(@RequestBody(required = true) Platform platform) {
      Platform createPlatform = platformService.createPlatform(platform.getName(), platform.getConstructor());
      return createPlatform;
   }

   @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
   public @ResponseBody Iterable<Platform> listPlatforms() {
      return platformService.list();
   }

}
