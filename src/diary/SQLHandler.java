package diary;

/*
    DataBase Schema can be located at h-t-t-p://ondras.--zarovi--.cz/sql/demo/ by name test_gardens_diary_database
    or at h-t-t-p://dbdesigner.net/designer/schema/150299
*/

import java.sql.*;

public class SQLHandler {
    private static Connection conn;
    private static PreparedStatement createNewNote;

    static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test_db.db");
            createNewNote = conn.prepareStatement("INSERT INTO Notes(USER_ID, NOTE_TEXT, CREATE_TIME, MODIFY_TIME) VALUES (?, ?, ?, ?)");
        } catch (Exception e) {
            System.out.println("Невозможно подключиться к БД");
        }
    }


    static void disconnect() {
        try {
            conn.close();
            System.out.println("Соединение с БД закрыто");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
