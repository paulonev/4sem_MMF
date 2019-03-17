package by.bsu.lab4.repository;

import java.sql.SQLException;

public interface TableOperations {
    void createTable() throws SQLException;
    void createExtraConstraints() throws SQLException; //для создания ограничений в полях таблиц БД
}
