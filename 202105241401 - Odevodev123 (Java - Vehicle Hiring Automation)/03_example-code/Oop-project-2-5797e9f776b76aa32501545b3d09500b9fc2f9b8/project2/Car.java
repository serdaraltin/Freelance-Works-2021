package project2;

class Car extends Vehicle{
        private String color;
	private Integer seatingCap;
	private Integer numOfDoors;
	private String carType;

	public Car(String plateNumber, Integer numberOfTires, String color, Integer seatingCap, Integer numOfDoors,
			String carType, Integer dailyFee) {
		super(plateNumber, numberOfTires,dailyFee);
                this.color = color;
		this.seatingCap = seatingCap;
		this.numOfDoors = numOfDoors;
		this.carType = carType;

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getSeatingCap() {
		return seatingCap;
	}

	public void setSeatingCap(Integer seatingCap) {
		this.seatingCap = seatingCap;
	}

	public Integer getNumOfDoors() {
		return numOfDoors;
	}

	public void setNumOfDoors(Integer numOfDoors) {
		this.numOfDoors = numOfDoors;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Override
	public Integer getHP() {
		if(carType.equals("Sport"))
			return HP;
		else
			System.out.println("This car has no HP attribute");

		return 0;
	}

	@Override
	public void setHP(Integer HP) {
		if(carType.equals("Sport"))
			super.setHP(HP) ;
		else
			System.out.println("This car has no HP attribute");
	}

	@Override
	public String getWD() {
		if(carType.equals("SUV"))
			return WD;
		else
			System.out.println("This car has no WD attribute");

		return "";
	}

	@Override
	public void setWD(String WD) {
		if(carType.equals("Sport"))
			super.setWD(WD) ;
		else
			System.out.println("This car has no WD attribute");
	}



	@Override
	public String toString() {
		return "Car [plateNumber=" + plateNumber  + ", seatingCap=" + seatingCap + ", numOfDoors=" + numOfDoors + ", carType="
				+ carType + ", color=" + color + ", numberOfTires=" + numberOfTires + ", dailyFee="
				+ dailyFee + "]";


	}
    
}
