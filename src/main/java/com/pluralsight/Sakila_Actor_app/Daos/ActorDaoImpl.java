package com.pluralsight.Sakila_Actor_app.Daos;

import com.pluralsight.Sakila_Actor_app.model.Actor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ActorDaoImpl implements ActorDao{
    private DataSource dataSource;

    public ActorDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Actor> getAllActors() {

        List<Actor> actors = new ArrayList<>();
        String query = "SELECT * FROM actor";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()
        ){while (resultSet.next()){
            Actor actor = new Actor(resultSet.getInt("actor_id"), resultSet.getString("first_name"), resultSet.getString("last_name"));
            actors.add(actor);
        }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return actors;
    }

    @Override
    public List<Actor> getAllActorsByFirstName(String firstName) {
        List<Actor> actors = new ArrayList<>();
        String query = "SELECT * FROM actor WHERE first_name = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setString(1, firstName);
            try(ResultSet resultSet = preparedStatement.executeQuery()
            )
            {while (resultSet.next()){
                Actor actor = new Actor(resultSet.getInt("actor_id"), resultSet.getString("first_name"), resultSet.getString("last_name"));
                actors.add(actor);
            }
        }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return actors;
    }

    @Override
    public List<Actor> getAllActorsByLast(String lastName) {
        List<Actor> actors = new ArrayList<>();
        String query = "SELECT * FROM actor WHERE last_name = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setString(1, lastName);
            try(ResultSet resultSet = preparedStatement.executeQuery()
            )
            {while (resultSet.next()){
                Actor actor = new Actor(resultSet.getInt("actor_id"), resultSet.getString("first_name"), resultSet.getString("last_name"));
                actors.add(actor);
            }
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return actors;
    }
}
