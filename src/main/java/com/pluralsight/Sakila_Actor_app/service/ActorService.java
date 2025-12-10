package com.pluralsight.Sakila_Actor_app.service;

import com.pluralsight.Sakila_Actor_app.Daos.ActorDao;
import com.pluralsight.Sakila_Actor_app.Daos.ActorDaoImpl;
import com.pluralsight.Sakila_Actor_app.model.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private ActorDao actorDao;

    public ActorService(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    public List<Actor> getActors() {
        return actorDao.getAllActors();
    }

    public List<Actor> getActorsByFirstName(String firstName) {
        return actorDao.getAllActorsByFirstName(firstName);
    }

    public List<Actor> getActorsByLastName(String lastName) {
        return actorDao.getAllActorsByLast(lastName);
    }
}
