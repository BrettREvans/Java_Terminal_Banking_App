package com.revature.project.zero.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface DataManager<E> {


    void create(E e) throws SQLException;

    //E getById(int id);

    List<E>  getAll();

    void update(E e);




}
