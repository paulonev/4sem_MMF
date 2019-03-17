package by.bsu.lab4.repository;

import by.bsu.lab4.ConnectToDB;
import by.bsu.lab4.Program;

import java.sql.*;
import java.io.Closeable;

// Сервисный родительский класс, куда вынесена реализация общих действий для всех таблиц
public class BaseTableCreator implements Closeable {
    private Connection connection;  // JDBC-соединение для работы с таблицей
    private String tableName;       // Имя таблицы

    BaseTableCreator(String tableName) {
        this.tableName = tableName;
        this.connection = ConnectToDB.getDb_connection(); //set up the connection with database
    }

    public String getTableName() {
        return tableName;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка закрытия SQL соединения!");
        }
    }

    // Выполнить SQL команду без параметров в СУБД, по завершению выдать сообщение в консоль
    void executeSqlStatement(String sql, String description) throws SQLException {
        reopenConnection(); // переоткрываем (если оно неактивно) соединение с СУБД
        Statement statement = connection.createStatement();  // Создаем statement для выполнения sql-команд
        statement.execute(sql); // Выполняем statement - sql команду
        statement.close();      // Закрываем statement для фиксации изменений в СУБД
        if (description != null)
            System.out.println(description);
    }

    void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, null);
    }

    // Активизация соединения с СУБД, если оно не активно.
    void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            this.connection = ConnectToDB.getDb_connection();
        }
    }
}
