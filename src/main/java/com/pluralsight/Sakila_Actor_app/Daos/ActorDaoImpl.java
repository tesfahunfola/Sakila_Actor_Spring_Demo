package com.pluralsight.Sakila_Actor_app.Daos;

import com.pluralsight.Sakila_Actor_app.model.Actor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
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
    public Actor getActorById(int id) {
        String query = "SELECT * FROM actor WHERE actor_id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    Actor actor = new Actor(resultSet.getInt("actor_id"), resultSet.getString("first_name"), resultSet.getString("last_name"));
                    return actor;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
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

    @Override
    public Actor addNewActor(Actor actor){
        String query = "INSERT into actor(first_name, last_name) VALUES(?, ?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ){
            preparedStatement.setString(1, actor.getFirstName());
            preparedStatement.setString(2, actor.getLastName());

            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next()) {
                actor.setId(keys.getInt(1));
                return actor;
            } else {
                throw new RuntimeException("actor not added");
            }

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void updateExistingActor(int id, Actor actor) {
        String query = "UPDATE actor SET first_name = ?, last_name =? WHERE actor_id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, actor.getFirstName());
            preparedStatement.setString(2, actor.getLastName());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteActor(int id) {
        String query = "DELETE FROM actor WHERE actor_id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
