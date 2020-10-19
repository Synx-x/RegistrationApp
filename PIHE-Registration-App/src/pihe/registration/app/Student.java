package pihe.registration.app;
import java.rmi.Remote;
import java.util.List;

public interface Student extends Remote {
 //getSales method
 public List < StudentEntries > getStudents() throws Exception;
}
