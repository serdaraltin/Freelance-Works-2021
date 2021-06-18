import java.util.Date;

public class TruckBooking {

    private Date startDate;
    private Date endDate;
    private Truck truck;
    private Person person;

    public TruckBooking() {
    }

    public TruckBooking(Date startDate, Date endDate, Truck truck, Person person) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
        this.truck = truck;
        this.person = person;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Truck getTruck() {
        return truck;
    }

    public Person getPerson() {
        return person;
    }
}
