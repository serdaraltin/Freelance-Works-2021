package Model;

public class Purchases {

    private int id;
    private int customerId;
    private int productId;
    private int piece;
    private float price;

    public Purchases() {
    }

    public Purchases(String[] data) {
        this.id = Integer.valueOf(data[0]);
        this.customerId = Integer.valueOf(data[1]);
        this.productId = Integer.valueOf(data[2]);
        this.piece = Integer.valueOf(data[3]);
        this.price = Float.valueOf(data[4]);
    }

    public Purchases(int id, int customerId, int productId, int piece, float price) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.piece = piece;
        this.price = price;
    }

    public Purchases(int customerId, int productId, int piece, float price) {
        this.customerId = customerId;
        this.productId = productId;
        this.piece = piece;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "," + customerId + "," + productId + "," + piece + "," + price;
    }

    public String getString() {

        return "Id          : " + id + "\n"
                + "Customer Id : " + customerId + "\n"
                + "Product Id  : " + productId + "\n"
                + "Piece       : " + piece + "\n"
                + "Price       : " + price;
    }

}
