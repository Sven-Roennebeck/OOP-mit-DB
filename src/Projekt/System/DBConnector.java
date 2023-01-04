package Projekt.System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnector {
    private static String url = "jdbc:mysql://localhost:3306/maasen";
    private static String user = "root";

    private static String password = "";
    private static String db = "mysqljava";
    private static String command;// = "insert into mysqljava values(11,'Robin','Fritz',54)";

    private static Connection con;// Verbindung zur DB
    private static Statement insert;

    //-------------------------------------Verbindung aufbauen------------------------------------------------------

    public void connectDB() {
        try {
            // Verbindung aufbauen
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Verbindung erfolgreich hergestellt");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //---------------------------------------Befehl an DB senden----------------------------------------------------

    public void sendCommand() {
        try {
            insert = con.createStatement();
            //    insert.execute("insert into mysqljava values(12,'Sven','Hans',34)");
            insert.execute(command);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setCommand(String command) {
        DBConnector.command = command;
    }
}
