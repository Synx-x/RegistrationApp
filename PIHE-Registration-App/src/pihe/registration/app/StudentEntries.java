package pihe.registration.app;

public class StudentEntries implements java.io.Serializable {
    //required variables

    private int id, cellNumber, age;
    private String name, surname, degree;
    //getters

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDegree() {
        return degree;
    }

    //setters
    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    void setDegree(String degree) {
        this.degree = degree;
    }

    void setAge(int age) {
        this.age = age;
    }

}
