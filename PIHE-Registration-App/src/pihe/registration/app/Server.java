package pihe.registration.app;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends ConnectionImpl {
 public Server() throws RemoteException {
 super();
 }
 public static void main(String args[]) {
 try {  // Instantiating the connection class
 ConnectionImpl obj = new ConnectionImpl();
 // exporting the remote object to the stub
 Student stub = (Student) UnicastRemoteObject.exportObject(obj, 1199);
 // Creating and Binding the remote object (stub) in the registry
 Registry registry = LocateRegistry.createRegistry(1199);
 registry.bind("service", stub);
 System.err.println("Server is ready….");
 } catch(Exception e) {
 System.err.println("Server exception: " + e.toString());
 e.printStackTrace();
 }
 }
}
