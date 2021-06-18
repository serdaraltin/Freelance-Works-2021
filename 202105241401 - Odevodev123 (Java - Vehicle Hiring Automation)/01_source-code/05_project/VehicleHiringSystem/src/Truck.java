
public class Truck {

    private String truckType;
    private String plateNumber;
    private Integer loadingCap;
    private int numberOfTires;
    private int dailyFee;

    public Truck(String plateNumber, Integer numberOfTires, Integer loadingCap, String truckType, Integer dailyFee) {
        super();
        this.truckType = truckType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Integer getLoadingCap() {
        return loadingCap;
    }

    public void setLoadingCap(Integer loadingCap) {
        this.loadingCap = loadingCap;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    @Override
    public String toString() {
        return "Plate Number     :" + plateNumber
                + "\nLoading Capacity :" + loadingCap
                + "\nTruck Type       :" + truckType
                + "\nNumber of Tires  :" + numberOfTires
                + "\nDaily Fee        :" + dailyFee;
    }
}
