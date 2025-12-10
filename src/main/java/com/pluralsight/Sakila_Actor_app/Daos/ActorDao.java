package com.pluralsight.Sakila_Actor_app.Daos;

import com.pluralsight.Sakila_Actor_app.model.Actor;

import java.util.List;

public interface ActorDao {
 List<Actor> getAllActors();
 List<Actor> getAllActorsByFirstName(String firstName);
 List<Actor> getAllActorsByLast(String lastName);

}
