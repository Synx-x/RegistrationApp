package pihe.registration.app;

import java.sql. * ;
import java.util.ArrayList;
import java.util.List;

public class ConnectionImpl implements Student {
 @Override
 public List < StudentEntries > getStudents() throws Exception {
 //Creating a new arraylist
 List < StudentEntries > list = new ArrayList < >();
 // JDBC driver name and database URL
 String DB_URL = "jdbc:mysql://localhost:3306/registrants?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
// Database credentials
 String USER = "root";
 String PASS = "";
 Connection conn = null;
 Statement stmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
 //Open a connection
 System.out.println("Connecting to database..");
 conn = DriverManager.getConnection(DB_URL, USER, PASS);
 System.out.println("Database connection sucessful.");
 //Execute a query
 System.out.println("Creating statement...");

 return list;
 }
}
