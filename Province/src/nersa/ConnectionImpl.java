package nersa;
import java.sql. * ;
import java.util.ArrayList;
import java.util.List;

public class ConnectionImpl implements Sales {
 @Override
 public List < Province > getSales() throws Exception {
 //Creating a new arraylist
 List < Province > list = new ArrayList < >();
 // JDBC driver name and database URL
 String DB_URL = "jdbc:mysql://localhost:3306/nersa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
 try {
 stmt = (Statement) conn.createStatement();
 String sql = "SELECT * FROM provincialsales";
 //Extracting data from result set
 ResultSet rs = stmt.executeQuery(sql);
 //Extract data from result set
 while (rs.next()) {
 // Retrieve by column name
 int id = rs.getInt("saleID");
 String provincename = rs.getString("province");
 int litres = rs.getInt("litres");
// Setting the values
 Province province = new Province();
 province.setID(id);
 province.setProvince(provincename);
 province.setLitres(litres);
 list.add(province);
 }
 rs.close();
 }
 catch(SQLException ex) {
 System.out.println(ex + "An error occurred connecting to database");
 }
 return list;
 }
}
