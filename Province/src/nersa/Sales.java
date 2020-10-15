package nersa;
import java.rmi.Remote;
import java.util.List;

public interface Sales extends Remote {
 //getSales method
 public List < Province > getSales() throws Exception;
}
