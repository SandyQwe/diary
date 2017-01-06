package diary;

import java.sql.*;

public class SQLHandler {
    private static Connection conn;
    private static PreparedStatement stmt;

    static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:diary.db");
//            stmt = conn.createStatement("");
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
