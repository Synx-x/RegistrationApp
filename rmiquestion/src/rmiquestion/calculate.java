package rmiquestion;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface calculate extends Remote {
 //declaring required methods
public int add(int n1, int n2) throws RemoteException;
 public int subtract(int m1, int m2) throws RemoteException;
 public int multiply(int o1, int o2) throws RemoteException;
 public int divide(int p1, int p2) throws RemoteException;
} 
