package rmiquestion;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class Server extends UnicastRemoteObject implements calculate {
 public Server() throws RemoteException {
 super();
 }
 //methods implementation
 @Override
 public int add(int n1, int n2) throws RemoteException {
 return n1 + n2;
 }@Override
 public int subtract(int m1, int m2) throws RemoteException {
 return m1 - m2;
 } 
@Override
 public int multiply(int o1, int o2) throws RemoteException {
 return o1 * o2;
 }
@Override
 public int divide(int p1, int p2) throws RemoteException {
 return p1 / p2;
 }
 public static void main(String args[]) {
 try {
 //creating server object
 Registry reg = LocateRegistry.createRegistry(1099);
 reg.rebind("Hi_server", new Server());
 System.out.println("Server is ready...");
 }
 catch(RemoteException e) {
 System.out.println("Exception" + e);
 }
 }
}
