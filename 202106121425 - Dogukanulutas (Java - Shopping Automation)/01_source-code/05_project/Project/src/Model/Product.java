package Model;

public class Product {

    private int id;
    private String name;
    private float price;
    private int stock;
    private int type;

    public Product() {
    }

    public Product(String[] data) {
        this.id = Integer.valueOf(data[0]);
        this.name = data[1];
        this.price = Float.valueOf(data[2]);
        this.stock = Integer.valueOf(data[3]);
        this.type = Integer.valueOf(data[4]);
    }

    public Product(int id, String name, float price, int stock, int type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.type = type;
    }

    public Product(String name, float price, int stock, int type) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.type = type;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + price + "," + stock + "," + type;
    }

    public String getString() {
        return "Id    : " + id + "\n"
                + "Name  : " + name + "\n"
                + "Price : " + price + "\n"
                + "Stock : " + stock;
    }

}
