
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtils {
    
    public static Connection getConnection()throws Exception {
        Class.forName ("com.mysql.cj.jdbc.Driver");
        
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopi?useTimezone=true&serverTimezone=UTC",
                "root", "Bancodedados123");
    }
    
}
