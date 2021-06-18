
public class Vehicle {

    protected String plateNumber;
    protected Integer numberOfTires;
    protected Integer dailyFee;
    protected Integer loadingCap;
    protected Integer HP;
    protected String WD;

    public Vehicle(String plateNumber, Integer numberOfTires, Integer dailyFee) {
        this.plateNumber = plateNumber;
        this.numberOfTires = numberOfTires;
        this.dailyFee = dailyFee;
    }

    public Vehicle(String plateNumber, Integer numberOfTires, Integer dailyFee, Integer loadingCap) {
        this.plateNumber = plateNumber;
        this.numberOfTires = numberOfTires;
        this.dailyFee = dailyFee;
        this.loadingCap = loadingCap;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Integer getNumberOfTires() {
        return numberOfTires;
    }

    public Integer getDailyFee(Integer numberOfDays) {
        return numberOfDays * this.dailyFee;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setNumberOfTires(Integer numberOfTires) {
        this.numberOfTires = numberOfTires;
    }

    public void setDailyFee(Integer dailyFee) {
        this.dailyFee = dailyFee;
    }

    public Integer getDailyFee() {
        return dailyFee;
    }

    public Integer getLoadingCap() {
        return loadingCap;
    }

    public void setLoadingCap(Integer loadingCap) {
        this.loadingCap = loadingCap;
    }

    public Integer getHP() {
        return 0;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public String getWD() {
        return "";
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

}
