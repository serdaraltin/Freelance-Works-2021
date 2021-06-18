package project2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class VehiclePark {
        private List<Car> cars ;
	private List<Truck> trucks ;
	private List<CarBooking> bookedCars ;
	private List<TruckBooking> bookedTrucks;
	private List<Person> users;
	private List<String> dailyLog;
	public static VehiclePark instance;

	private VehiclePark() {
		cars = new ArrayList<Car>();
		trucks = new ArrayList<Truck>();
		bookedCars = new ArrayList<CarBooking>();
		bookedTrucks = new ArrayList<TruckBooking>();
		users = new ArrayList<Person>();
		dailyLog = new ArrayList<String>();

		Person admin = new Person();
		admin.setId("admin");
		admin.setName("Admin");
		admin.setContactNo("1234");
		users.add(admin);
		loadRegisterUser();
	}

	public static synchronized VehiclePark getInstance(){
		if(instance == null)
			instance = new VehiclePark();
		return instance;
	}

	public ArrayList<Car> getCars() {
		return (ArrayList<Car>)cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public ArrayList<Truck> getTrucks() {
		return (ArrayList<Truck>) trucks;
	}

	public void setTrucks(List<Truck> trucks) {
		this.trucks = trucks;
	}

	public ArrayList<Person> getUsers() {
		return (ArrayList<Person>)users;
	}

	public void setUsers(List<Person> users) {
		this.users = users;
	}

	public void displayVehicles() throws SorryWeDontHaveThatOneException{

		for (Car car : cars) {
			System.out.println(car.toString());
		}
		for (Truck truck : trucks) {
			System.out.println(truck.toString());
		}
		
		if(cars.size()==0 && trucks.size()==0)
		{
			throw new SorryWeDontHaveThatOneException();
		}
	}
	
	
	// is available
	// available chars check//tekrar test
	private Integer AvailableCars(Date startDate,Date endDate)
	{
		Integer availableVehicle=0;
		
		Boolean isAvailable;
		
		for (Car car : cars) {
			isAvailable=true;
			
			for (CarBooking booked : bookedCars) {
				if(booked.getCar().getPlateNumber().equals(car.getPlateNumber()))
				{
					if(startDate.before(booked.getStartDate()) && startDate.before(booked.getEndDate()) &&
						endDate.before(booked.getStartDate()) && endDate.before(booked.getEndDate()))
					{
						isAvailable=true;
					}
					else if(startDate.after(booked.getStartDate()) && startDate.after(booked.getEndDate())
							&& endDate.after(booked.getStartDate()) && endDate.after(booked.getEndDate()))
					{
						isAvailable=true;
					}
					else 
						isAvailable=false;
					break;
				}
			}
			if(isAvailable)
			{
				availableVehicle++;
				System.out.println(car.toString());
			}
		}
		return availableVehicle;
	}
	
	private Integer AvailableTrucks(Date startDate,Date endDate)
	{
		Integer availableVehicle=0;
		Boolean isAvailable;
		for (Truck truck: trucks) {
			isAvailable=true;
			
			for (TruckBooking booked : bookedTrucks) {
				if(booked.getTruck().getPlateNumber().equals(truck.getPlateNumber()))
				{
					if(startDate.before(booked.getStartDate()) && startDate.before(booked.getEndDate()) &&
						endDate.before(booked.getStartDate()) && endDate.before(booked.getEndDate()))
					{
						isAvailable=true;
					}
					else if(startDate.after(booked.getStartDate()) && startDate.after(booked.getEndDate())
							&& endDate.after(booked.getStartDate()) && endDate.after(booked.getEndDate()))
					{
						isAvailable=true;
					}
					else 
						isAvailable=false;
					
				}
			}
			if(isAvailable)
			{	availableVehicle++;
				System.out.println(truck.toString());
			}
		}
		return availableVehicle;
		
	}
	
	public void displayAvailableVehicles(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException {
		
		Integer totalVehicle =this.AvailableCars(startDate,endDate);
		totalVehicle+=this.AvailableTrucks(startDate,endDate);
		if(totalVehicle==0)
			throw new SorryWeDontHaveThatOneException();
	}

	public void displayAvailableVehicles(Date startDate, Date endDate,Integer type) throws SorryWeDontHaveThatOneException {
		
		Integer totalVehicle=0;
		if(type==1)
			totalVehicle=this.AvailableCars(startDate,endDate);
		else if(type==2)
			totalVehicle+=this.AvailableTrucks(startDate,endDate);
		
		if(totalVehicle==0)
			throw new SorryWeDontHaveThatOneException();
	}

	// only admin can do
	public void addVehicle(String plateNumber,Integer numberOfTires,String color, Integer seatingCap, Integer numOfDoors, Integer carType,Integer dailyFee) {

		String type;
			if(carType==1) type = "Sports";
			else if(carType==2) type = "SW";
			else type = "SUV";
			cars.add(new Car(plateNumber, numberOfTires, color, seatingCap, numOfDoors, type, dailyFee));
	}
	public void addVehicle(String plateNumber,Integer numberOfTires,Integer loadingCap, Integer truckType,Integer dailyFee) {
		
			String type;
			if(truckType==1) type = "Small Trucks";
			else type = "Transport Trucks";

			trucks.add(new Truck(plateNumber, numberOfTires, loadingCap, type, dailyFee));
	}

	public boolean removeVehicle(String plateNumber,Integer type) {

		if(type==1)
		{
			Iterator<Car> carIterator = cars.iterator();
			while (carIterator.hasNext()) {
				Car car = carIterator.next();
				if(car.getPlateNumber().equals(plateNumber))
				{
					carIterator.remove();
					return true;
				}
				break;
			}
			
		}
		else if(type==2)
		{
			Iterator<Truck> truckIterator = trucks.iterator();
			while (truckIterator.hasNext()) {
				Truck truck= truckIterator.next();
				if(truck.getPlateNumber().equals(plateNumber))
				{
					truckIterator.remove();
					return true;
				}
				break;
				
			}
		}
		return false;
	}

	public void dailyReport(String filename) {
		try {
			FileWriter fw = new FileWriter(filename);

			System.out.println("User ID\tType\tFees");
			for (CarBooking carBooking : bookedCars) {
				Integer days = (int) (carBooking.getEndDate().getTime() - carBooking.getStartDate().getTime()) / (1000 * 60 * 60 * 24);
				fw.write(carBooking.getPerson().getId() + "\t" + "CAR\t" + carBooking.getCar().getDailyFee(days) + System.lineSeparator());
			}

			fw.close();
		}catch (IOException e) {
				e.printStackTrace();
		}

	}

	// registered user
	public void bookVehicle(Integer type,String plateNumber,Date startDate,Date endDate,Person person) throws SorryWeDontHaveThatOneException{

		boolean isVehicleFound=false;
		if(type==1)
		{
			for (Car car : cars) {
				if(car.getPlateNumber().equals(plateNumber))
				{
					bookedCars.add(new CarBooking(startDate, endDate,car, person ));
					isVehicleFound=true;
					break;
				}
			}			
		}else if(type==2)
		{
			Date today = new Date();
			
			if( ((startDate.getTime()-today.getTime()) /(1000 * 60 * 60 * 24)+1)<7)
			{
				System.out.println("Vehicle should be booked before 7 days");
			}
			else
			{
				for (Truck truck: trucks) {
					if(truck.getPlateNumber().equals(plateNumber))
					{
						bookedTrucks.add(new TruckBooking(startDate, endDate,truck, person ));
						isVehicleFound=true;
						break;
					}
				}
			}
		}
		
		if(isVehicleFound==false)
		{
			throw new SorryWeDontHaveThatOneException();
		}else
		{
			System.out.println("Vehicle booked successfully");
		}
	}

	public void cancelBooking(Integer type,String plateNumber) throws SorryWeDontHaveThatOneException, NoCancellationYouMustPayException {

		Date date = new Date();
		boolean isVehicleFound=false;
		if(type==1)
		{
			Iterator<CarBooking> iterator = bookedCars.iterator();
			while(iterator.hasNext())
			{
				CarBooking booked = iterator.next();
				
				if(booked.getCar().getPlateNumber().equals(plateNumber))
				{
					if(date.after(booked.getStartDate()))
					{
						throw new NoCancellationYouMustPayException();
					}
					iterator.remove();
					isVehicleFound=true;
					break;
				}
			}			
		}else if(type==2)
		{
			Iterator<TruckBooking> iterator = bookedTrucks.iterator();
			while(iterator.hasNext())
			{
				TruckBooking booked = iterator.next();
				
				if(booked.getTruck().getPlateNumber().equals(plateNumber))
				{
					iterator.remove();
					isVehicleFound=true;
					break;
				}
			}
		}
		
		if(isVehicleFound==false)
		{
			throw new SorryWeDontHaveThatOneException();
		}

	}

	public void rentVehicle(Date startDate,Date endDate,String startLocation,String endLocation,String plateNumber,Person person) throws SorryWeDontHaveThatOneException {

		Optional<Car> carOp = cars.stream().filter(o -> o.getPlateNumber().equals(plateNumber)).findFirst();
		
		if(carOp.isPresent())
		{
			if(carOp.get().getCarType().equals("SUV"))
			{
				System.out.println("Neither remote delivery, nor remote dropping off is possible.");
			}
			else
			{
				CarBooking carBooking = new CarBooking(startDate, endDate, carOp.get(), person, startLocation, endLocation);
				bookedCars.add(carBooking);
				System.out.println("Vehicle booked successfully");
			}
		}
		else
			throw new SorryWeDontHaveThatOneException();
	}

	public void dropVehicle(Integer type,String plateNumber) {
		
		if(type==1)
		{
			Iterator<CarBooking> booked = bookedCars.iterator();
			
			while(booked.hasNext())
			{
				CarBooking booking = booked.next();
				if(booking.getCar().getPlateNumber().equals(plateNumber))
				{
					booked.remove();
					System.out.println("Vehicle droped");
					break;
				}
			}
		}
		else if(type==2)
		{
			Iterator<TruckBooking> booked = bookedTrucks.iterator();
			
			while(booked.hasNext())
			{
				TruckBooking booking = booked.next();
				if(booking.getTruck().getPlateNumber().equals(plateNumber))
				{
					booked.remove();
					System.out.println("Vehicle droped");
					break;
				}
			}
		}
		
	}

	public void load(int type,int addLoad,String platenumber) throws OverWeightException, SorryWeDontHaveThatOneException {
		if(type==1)
			load_c(platenumber,addLoad);
		else
			load_t(platenumber,addLoad);
	}

	private void load_c(String plateNumber,int addLoad) throws OverWeightException, SorryWeDontHaveThatOneException {
		Optional<Car> carOp = cars.stream().filter(o -> o.getPlateNumber().equals(plateNumber)).findFirst();

		if(carOp.isPresent()) {
			if (carOp.get().getCarType().equals("SW")){
				if(carOp.get().getLoadingCap() >= addLoad) {
					carOp.get().setLoadingCap(carOp.get().getLoadingCap()-addLoad);
					System.out.println("SW loaded successfully. You have "+carOp.get().getLoadingCap()+" more loading cap");
				}else{
					throw new OverWeightException("");
				}
			} else {
					System.out.println("Cars except SW cannot be loaded");
					throw new SorryWeDontHaveThatOneException();
			}
		}
	}

	private void load_t(String plateNumber,int addLoad) throws OverWeightException, SorryWeDontHaveThatOneException {
		Optional<Truck> truckOp = trucks.stream().filter(o -> o.getPlateNumber().equals(plateNumber)).findFirst();

		if(truckOp.isPresent()) {
				if(truckOp.get().getLoadingCap() >= addLoad) {
					truckOp.get().setLoadingCap(truckOp.get().getLoadingCap()-addLoad);
					System.out.println("Truck loaded successfully. You have "+truckOp.get().getLoadingCap()+" more loading cap");
				}else{
					throw new OverWeightException("");
				}
		} else{
			throw new SorryWeDontHaveThatOneException();
		}

	}
	// read user
	private void loadRegisterUser() {

		File file = new File("users.txt");

		if (file.exists()) {
			try {
				Scanner scnFile = new Scanner(file);
				while(scnFile.hasNextLine()){
					String temp = scnFile.nextLine();

					String[] att = temp.split(" ");
					Person tempp = new Person();

					tempp.setId(att[0]);
					tempp.setName(att[1]);
					tempp.setContactNo(att[2]);

					System.out.println("Load registered user : "+tempp.toString());
					users.add(tempp);
				}


			}

			catch (IOException  e1) {
				// TODO Auto-generated catch block
			}
		}


	}

	public void saveRegisterUser() {

		Person admin = new Person();
		admin.setId("admin");

		File file = new File("users.txt");
		if (file.exists()) {

			try {
				FileWriter writer = new FileWriter(file);
				for(Person user: users)
					writer.write(user.getId()+" "+user.getName()+" "+user.getContactNo()+System.lineSeparator());
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}

		}

	}
	
	// add user
	public void addUser(String id, String name, String contactNo, String address, String licenseNo)
	{
		System.out.println("Before Adding user :  "+ users.toString());
		users.add(new Person(id, name, contactNo, address, licenseNo));
		System.out.println("After Adding user :  "+ users.toString());
	}
	
	// is user exist
	public Optional<Person> isValidUserId(String id)
	{
		return users.stream().filter(obj -> obj.getId().equals(id)).findFirst();
	}
    
}
