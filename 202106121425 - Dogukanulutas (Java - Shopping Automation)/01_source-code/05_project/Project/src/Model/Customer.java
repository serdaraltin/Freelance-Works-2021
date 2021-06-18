package Model;

public class Customer {

    private int id;
    private String name;
    private String password;

    public Customer() {
    }

    public Customer(String[] data) {
        this.id = Integer.valueOf(data[0]);
        this.name = data[1];
        this.password = data[2];
    }

    public Customer(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + password;
    }

    public String getString() {
        return "Id       : " + id + "\n"
             + "Name     : " + name + "\n"
             + "Password : " + password;
    }

}
