package Connecteur;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class BaseManager {
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(""
        +"jdbc:mysql://localhost:8889/Banco?"
        +"useUnicode=true&useJDBCCompliantTimezoneShift=true"
        +"&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
    }
}
