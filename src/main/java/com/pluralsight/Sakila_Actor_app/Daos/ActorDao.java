package com.pluralsight.Sakila_Actor_app.Daos;

import javax.sql.DataSource;
import java.util.List;

public class ActorDao {
    private DataSource dataSource;

    public ActorDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<ActorDao> get
}
