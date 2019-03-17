package by.bsu.lab4;

import java.sql.*;

public class ConnectToDB {
    //необходимость устанавливать здесь соединение с базой данных
    //проверять наличие драйвера
    //создать
    private static Connection db_connection;

    public static void setDb_connection(String db_driver, String db_url) throws ClassNotFoundException, SQLException {
        Class.forName(db_driver); //check for existence of jdbc driver
        db_connection = DriverManager.getConnection(db_url); // establish connection
    }

    public static Connection getDb_connection() {
        return db_connection;
    }
}
