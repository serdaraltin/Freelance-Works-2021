package Model;

public class Tv extends Product {

    private String screenSize;

    public Tv() {
    }

    public Tv(String[] data) {
        super(data);
        this.screenSize = data[5];
    }

    public Tv(int id, String name, float price, int stock, String screenSize) {
        super(id, name, price, stock, 1);
        this.screenSize = screenSize;
    }

    public Tv(String name, float price, int stock, String screenSize) {
        super(name, price, stock, 1);
        this.screenSize = screenSize;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return super.toString() + "," + screenSize;
    }

    @Override
    public String getString() {
        return super.getString() + "\n"
                + "Screen Size : " + screenSize;
    }

}
