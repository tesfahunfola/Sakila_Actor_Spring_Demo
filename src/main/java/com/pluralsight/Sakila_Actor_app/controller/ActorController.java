package com.pluralsight.Sakila_Actor_app.controller;

import com.pluralsight.Sakila_Actor_app.service.ActorService;
import com.pluralsight.Sakila_Actor_app.model.Actor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("actors")
public class ActorController {
    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> getAll() {
        return actorService.getActors();
    }

    @GetMapping("{id}")
    public Actor getById(@PathVariable int id){
        return actorService.getActorById(id);
    }
    @GetMapping("search/{firstName}")
    public List<Actor> getActorsByFirstName(@RequestParam(required = false) String firstName) {
        return actorService.getActorsByFirstName(firstName);
    }

    @GetMapping("search/{lastName}")
    public List<Actor> getActorsByLastName(@RequestParam(required = false) String lastName) {
        return actorService.getActorsByLastName(lastName);
    }

    @PostMapping
    public Actor addNewActor(@RequestBody Actor actor){
        return actorService.addNewActor(actor);

    }

    @PostMapping("{id}")
    public void updateActor(@PathVariable int id, @RequestBody Actor actor){
        actorService.updateActor(id, actor);
    }


    @DeleteMapping("{id}")
    public void deleteActor(@PathVariable int id){
        actorService.deleteActor(id);
    }
}
