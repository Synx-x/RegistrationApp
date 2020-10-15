package rmiquestion;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public final class Client extends JFrame implements ActionListener {
 //constructor
 public Client() {
 super("Edureka Calculator App");
 this.setSize(400, 200);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 createPanel();
 this.getContentPane().add(myPanel);
 this.setVisible(true);
 }
 //required components
 JComboBox cb = new JComboBox();
 JButton calcbutton = new JButton();
 JTextField num1 = new JTextField();
 JTextField num2 = new JTextField();
 JLabel labeltop = new JLabel("Edureka Calculator App v1.0");
 JLabel labeltop2 = new JLabel("Developer: S.M Makura");
 JLabel label = new JLabel("Input 1st Number:");
 JLabel label1 = new JLabel("Choose Symbol:");
 JLabel label2 = new JLabel("Input 2nd Number:");
 JLabel result = new JLabel();
 JPanel myPanel = new JPanel(); //create Panel
public void createPanel() {
 myPanel.setLayout(new GridLayout(5, 2));
 //first number
 num1 = new JTextField(10);
 num1.setHorizontalAlignment(SwingConstants.CENTER);
 //symbol
 String symbols[] = {
 "+",
 "-",
 "*",
 "/"
};
 cb = new JComboBox(symbols);
 ((JLabel) cb.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
 //second number
 num2 = new JTextField(10);
 num2.setHorizontalAlignment(SwingConstants.CENTER);
 result.setHorizontalAlignment(SwingConstants.CENTER);
 //Calculate button
 calcbutton = new JButton("Calculate");
 //adding components to panel
 myPanel.add(labeltop);
 myPanel.add(labeltop2);
 myPanel.add(label);
 myPanel.add(num1);
 myPanel.add(label1);
 myPanel.add(cb);
 myPanel.add(label2);
 myPanel.add(num2);
 myPanel.add(calcbutton);
 myPanel.add(result); add(myPanel);
 calcbutton.addActionListener((ActionListener) this);
 }
 public static void main(String args[]) throws RemoteException {
 Client c = new Client();
 }
 //calcbutton.addActionListener();
 @Override
 public void actionPerformed(ActionEvent e) {
 //handling empty textfields
 if ("".equals(num1.getText()) || "".equals(num2.getText())) {
JOptionPane.showMessageDialog(null, "Please Enter Numbers first", "Error", JOptionPane.ERROR_MESSAGE);
 }
 else {
 int one = Integer.parseInt(num1.getText());
 int two = Integer.parseInt(num2.getText());
 char op = cb.getSelectedItem().toString().charAt(0);
 try {
 int answer;
 //locating remote object and registering it to RMI
 Registry reg = LocateRegistry.getRegistry();
 calculate cal = (calculate) reg.lookup("Hi_server");
 //using switch statement to handle calculations
 switch (op) {
 case '+':
 answer = cal.add(one, two);
 result.setText(Integer.toString(answer));
 break;
 case '-':
 answer = cal.subtract(one, two);
 result.setText(Integer.toString(answer));
 break; case '*':
 answer = cal.multiply(one, two);
 result.setText(Integer.toString(answer));
 break;
 case '/':
 answer = cal.divide(one, two);
 result.setText(Integer.toString(answer));
 break;
 // operator doesn't match any case constant (+, -, *, /)
 default:
 System.out.printf("Error! operator is not correct");
 }
}
 catch(NumberFormatException | NotBoundException | RemoteException f) {
 System.out.println("Exception" + f);
 }
 }
 }
}
