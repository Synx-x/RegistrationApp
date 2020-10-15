package nersa;

public class Province implements java.io.Serializable {
 //required variables
 private int id,
 litres;
 private String province;
 //getters
 public int getId() {
 return id;
 }
 public String getProvince() {
 return province;
 }
 public int getLitres() {
 return litres;
 }
 //setters
 public void setID(int id) {
 this.id = id;
 }
 public void setProvince(String province) {
 this.province = province; 
}
 public void setLitres(int litres) {
 this.litres = litres;
 }
}
