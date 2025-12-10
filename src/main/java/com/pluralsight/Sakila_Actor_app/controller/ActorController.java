package com.pluralsight.Sakila_Actor_app.controller;

import com.pluralsight.Sakila_Actor_app.service.ActorService;
import com.pluralsight.Sakila_Actor_app.model.Actor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ActorController {
    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> getAll() {
        return actorService.getActors();
    }

    @GetMapping("first/{firstName}")
    public List<Actor> getActorsByFirstName(@PathVariable String firstName) {
        return actorService.getActorsByFirstName(firstName);
    }

    @GetMapping("last/{lastName}")
    public List<Actor> getActorsByLastName(@PathVariable String lastName) {
        return actorService.getActorsByLastName(lastName);
    }
}
