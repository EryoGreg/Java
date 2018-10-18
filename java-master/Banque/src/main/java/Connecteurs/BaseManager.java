package Connecteurs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseManager {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:8889/Java_Banque?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false","root","root");
    }
}
