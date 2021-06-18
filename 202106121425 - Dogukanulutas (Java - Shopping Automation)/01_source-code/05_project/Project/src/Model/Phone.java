package Model;

public class Phone extends Product {

    private String cameraResolution;

    public Phone() {
    }

    public Phone(String[] data) {
        super(data);
        this.cameraResolution = data[5];
    }

    public Phone(int id, String name, float price, int stock, String cameraResolution) {
        super(id, name, price, stock, 2);
        this.cameraResolution = cameraResolution;
    }

    public Phone(String name, float price, int stock, String cameraResolution) {
        super(name, price, stock, 2);
        this.cameraResolution = cameraResolution;
    }

    public String getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(String cameraResolution) {
        this.cameraResolution = cameraResolution;
    }

    @Override
    public String toString() {
        return super.toString() + "," + cameraResolution;
    }

    @Override
    public String getString() {
        return super.getString() + "\n"
                + "Camera Resolution : " + cameraResolution;
    }

}
