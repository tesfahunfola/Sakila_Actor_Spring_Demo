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
    public Actor getActorById(int id) {
        return actorDao.getActorById(id);
    }

    public List<Actor> getActorsByFirstName(String firstName) {
        return actorDao.getAllActorsByFirstName(firstName);
    }

    public List<Actor> getActorsByLastName(String lastName) {
        return actorDao.getAllActorsByLast(lastName);
    }


    public Actor addNewActor(Actor actor) {
        return actorDao.addNewActor(actor);
    }

    public void updateActor(int id, Actor actor) {
        Actor actorToUpdate = getActorById(id);
        if(actor.getFirstName() != null) {
            actorToUpdate.setFirstName(actor.getFirstName());
        }
        if(actor.getLastName() != null) {
            actorToUpdate.setLastName(actor.getLastName());
        }
        actorDao.updateExistingActor(id, actorToUpdate);
    }

    public void deleteActor(int id) {
        actorDao.deleteActor(id);
    }
}
