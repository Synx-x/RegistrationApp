package nersa;
import java.awt.BorderLayout;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util. * ;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Client extends JFrame {
 //constructor
 private Client() {
 super("NERSA Sales Results");
 setLocationRelativeTo(null);
 setSize(400, 200);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setVisible(true);
}
 public static void main(String[] args) throws Exception {
 //creating a new table
 JTable table = new JTable();
 DefaultTableModel model = new DefaultTableModel();
 Object[] columnsName = new Object[3];
 columnsName[0] = "saleID";
 columnsName[1] = "Province";
 columnsName[2] = "Litres";
 model.setColumnIdentifiers(columnsName);
Object[] rowData = new Object[3];
 try {
 // Getting the registry
 Registry registry = LocateRegistry.getRegistry(null);
 // Looking up the registry for the remote object
 Sales stub = (Sales) registry.lookup("Hello");
 // Calling the remote method using the obtained object
 List < Province > list = (List) stub.getSales();
 //iterating through the list and adding to table rows
 for (Province s: list) {
 rowData[0] = s.getId();
 rowData[1] = s.getProvince();
 rowData[2] = s.getLitres();
 model.addRow(rowData);
 }
 table.setModel(model);
 } catch(Exception e) {
 System.err.println("Client exception: " + e.toString());
 e.printStackTrace();
 }  Client client = new Client();
 JPanel panel = new JPanel();
 panel.setLayout(new BorderLayout());
 JScrollPane pane = new JScrollPane(table);
 panel.add(pane, BorderLayout.CENTER);
 client.setContentPane(panel);
 }
}
