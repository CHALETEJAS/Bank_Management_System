package bankManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	
    Connection c;
    Statement s;
    
    public Conn() {
        try {
            // Load the JDBC driver if necessary
            // Class.forName("com.mysql.cj.jdbc.Driver"); // Uncomment if needed
            
            // Correct JDBC URL
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "Tejas@1996");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
