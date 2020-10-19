package pihe.registration.app;

import java.rmi.ConnectException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConnectInterface extends Client {

    int id, cellNumber, age = 0;
    String name, surname, degree = "";

    public void Insert() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registrants?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            String sql = "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            // Looking up the registry for the remote object
            Student stub = (Student) registry.lookup("service");
            List< StudentEntries> list = (List) stub.getStudents();
            //iterating through the list 
            for (StudentEntries s : list) {
                id = s.getId();
                name = s.getName();
                surname = s.getSurname();
                age = s.getAge();
                cellNumber = s.getCellNumber();
                degree = s.getDegree();

            }


        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty.");
        } catch (Exception e) {
         
        }

    }
}
