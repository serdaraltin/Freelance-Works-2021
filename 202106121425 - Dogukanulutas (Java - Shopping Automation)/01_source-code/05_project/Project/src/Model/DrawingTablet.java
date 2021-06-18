package Model;

public class DrawingTablet extends Product {

    private byte batteryless;

    public DrawingTablet() {
    }

    public DrawingTablet(String[] data) {
        super(data);
        this.batteryless = Byte.parseByte(data[5]);
    }

    public DrawingTablet(int id, String name, float price, int stock, byte batteryless) {
        super(id, name, price, stock, 3);
        this.batteryless = batteryless;
    }

    public DrawingTablet(String name, float price, int stock, byte batteryless) {
        super(name, price, stock, 3);
        this.batteryless = batteryless;
    }

    public byte getCameraResolution() {
        return batteryless;
    }

    public void setCameraResolution(byte batteryless) {
        this.batteryless = batteryless;
    }

    @Override
    public String toString() {
        return super.toString() + "," + batteryless;
    }

    @Override
    public String getString() {
        return super.getString() + "\n"
                + "Battery Less : " + batteryless;
    }

}
