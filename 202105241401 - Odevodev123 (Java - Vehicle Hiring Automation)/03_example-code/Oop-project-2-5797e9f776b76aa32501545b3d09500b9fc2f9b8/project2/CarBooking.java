package project2;

import java.util.Date;

public class CarBooking {
        private Date startDate;
	private Date endDate;
	private Car car;
	private Person person;
	private String startLocation, endLocation;

	public CarBooking() {
		// TODO Auto-generated constructor stub
	}

	public CarBooking(Date startDate, Date endDate, Car car) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.car = car;
	}

	public CarBooking(Date startDate, Date endDate, Car car, Person person) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.car = car;
		this.person = person;
	}

	
	public CarBooking(Date startDate, Date endDate, Car car, Person person, String startLocation, String endLocation) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.car = car;
		this.person = person;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Car getCar() {
		return car;
	}

	public Person getPerson() {
		return person;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
    
}
