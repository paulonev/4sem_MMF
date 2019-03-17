package by.bsu.lab4.repository;

import java.sql.Connection;
import java.sql.SQLException;

/**This class is used to show HOW DATABASE ENTITIES ARE CREATED
 * Extends BaseTableCreator with methods for executing SQL queries
 * and control connection between table and database
 */
public class Trains extends BaseTableCreator implements TableOperations {
    public Trains() {
        super("Trains");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS Trains("+
                                "id bigint NOT NULL AUTO_INCREMENT,"+
                                "arrivalPoint varchar(50) NOT NULL,"+
                                "trainNumber bigint NOT NULL,"+
                                "departureTime time NOT NULL,"+
                                "seatsAll integer NOT NULL,"+
                                "seatsCoupe integer DEFAULT 0,"+
                                "seatsPl integer DEFAULT 0,"+
                                "seatsLux integer DEFAULT 0,"+
                                "CONSTRAINT PK_Trains_id PRIMARY KEY (id))","Создана таблица " + getTableName()
        );
    }

    @Override
    public void createExtraConstraints() throws SQLException {
        super.executeSqlStatement(
                "ALTER TABLE Trains ADD CONSTRAINT check_allSeats CHECK(seatsAll = seatsCoupe + seatsPl + seatsLux)",
                "Создано ограничение на поле check_allSeats таблицы " + getTableName()
        );
    }
}
