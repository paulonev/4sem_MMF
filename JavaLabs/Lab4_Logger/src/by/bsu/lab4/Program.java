package by.bsu.lab4;

import by.bsu.lab4.repository.Trains;

import java.sql.SQLException;

public class Program {
    //declaration of constants
    public static final String DB_URL = "jdbc:h2:/e:/4sem_MMF/JavaLabs/Lab4_Logger/db/trains";
    public static final String DB_Driver = "org.h2.Driver";

    public static void main(String[] args){
        try {
            ConnectToDB.setDb_connection(DB_Driver,DB_URL);

            Trains trains = new Trains();
            trains.createTable();
            trains.createExtraConstraints(); // добавление ограничений на столбцы таблиц

        } catch(ClassNotFoundException e){
            //обработка ошибки Class.forName
            e.printStackTrace();
            System.out.println("JDBC драйвер для СУБД не найден.");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Ошибка SQL!");
        }
    }
}
