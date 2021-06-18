package project2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SorryWeDontHaveThatOneException {
		
		Scanner scanner = new Scanner(System.in);
		VehiclePark vehiclePark = VehiclePark.getInstance();
		Person currentUser;
		int choice=0;



		do {
			
			System.out.println("\n==========Menu==========\n");
			System.out.println("1: Display all vehicles");
			System.out.println("2: Display available vehicles");
			System.out.println("3: Register me");
			System.out.println("4: Continue as registered user");
			System.out.println("5: Continue as admin");
			System.out.println("6: Quit\n");

			System.out.print("Select Option : ");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				try {
					vehiclePark.displayVehicles();
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				scanner.nextLine();
				break;
			case 2:
				
				System.out.print("Enter Start Date (dd/MM/YYYY): ");
				String sDate = scanner.nextLine();
				System.out.print("Enter End Date (dd/MM/YYYY): ");
				String eDate = scanner.nextLine();
				
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				try {
					Date startDate = format.parse(sDate);
					Date endDate = format.parse(eDate);
                                        
					vehiclePark.displayAvailableVehicles(startDate, endDate);
				} catch (ParseException e1) {
					System.out.println("Invalid Date Format");
				}
				scanner.nextLine();
				break;
			case 3:
				System.out.print("Enter User Id: ");
				String userId = scanner.nextLine();
				
				System.out.print("Enter Name: ");
				String name = scanner.nextLine();
				
				System.out.print("Enter Contact No: ");
				String contactNo = scanner.nextLine();

				System.out.print("Enter Address: ");
				String address = scanner.nextLine();

				System.out.print("Enter licenseNo: ");
				String licenseNo = scanner.nextLine();
				
				vehiclePark.addUser(userId, name, contactNo, address, licenseNo);
				
				System.out.println("User register successfully");
				scanner.nextLine();
				
				break;
			case 4:
				System.out.print("Enter user Id: ");
				userId = scanner.nextLine();
				Optional<Person> userOp =vehiclePark.isValidUserId(userId);
				if(userOp.isPresent())
				{
					currentUser = userOp.get();
					Integer subChoice=0;
					do
					{
						System.out.println("\n==========Sub Menu==========\n");
						System.out.println("1: Display all vehicles");
						System.out.println("2: Display available vehicles");
						System.out.println("3: Display available vehicles by type");
						System.out.println("4: Book vehicle");
						System.out.println("5: Cancel my booking");
						System.out.println("6: Rent vehicle");
						System.out.println("7: Drop vehicle");
						System.out.println("8: Quit");
						
						
						System.out.print("\n\nSelect Option : ");
						subChoice=scanner.nextInt();
						scanner.nextLine();
						
						switch (subChoice) {
						case 1: 
								try {
								vehiclePark.displayVehicles();
								}catch (Exception e) {
									System.out.println(e.getMessage());
								}
						scanner.nextLine();
								break;
						
						case 2:
							System.out.print("\nEnter Start Date (dd/MM/YYYY): ");
							sDate = scanner.nextLine();
							System.out.print("Enter End Date (dd/MM/YYYY): ");
							eDate = scanner.nextLine();
							
							format = new SimpleDateFormat("dd/MM/yyyy");
							try {
								Date startDate = format.parse(sDate);
								Date endDate = format.parse(eDate);
								vehiclePark.displayAvailableVehicles(startDate, endDate);
							} catch (ParseException e1) {
								System.out.println("Invalid Date Format");
							} catch (SorryWeDontHaveThatOneException e) {
								System.out.println(e.getMessage());
							}
							
							break;
							
						case 3:
							
							System.out.println("\n==========Vehical Type Menu==========\n");
							System.out.println("1: Car");
							System.out.println("2: Truck");;
							
							
							System.out.print("\n\nSelect Option : ");
							Integer vehicleType = scanner.nextInt();
							scanner.nextLine();
							
							System.out.print("Enter Start Date (dd/MM/YYYY): ");
							sDate = scanner.nextLine();
							System.out.print("Enter End Date (dd/MM/YYYY): ");
							eDate = scanner.nextLine();
							
							format = new SimpleDateFormat("dd/MM/yyyy");
							try {
								Date startDate = format.parse(sDate);
								Date endDate = format.parse(eDate);
								vehiclePark.displayAvailableVehicles(startDate, endDate,vehicleType);
							} catch (ParseException e1) {
								System.out.println("Invalid Date Format");
							} catch (SorryWeDontHaveThatOneException e) {
								System.out.println(e.getMessage());
							}
							
							break;
							
						case 4:
							
							System.out.println("\n==========Vehical Type Menu==========\n");
							System.out.println("1: Car");
							System.out.println("2: Truck");;
							
							
							System.out.print("\n\nSelect Option : ");
							vehicleType = scanner.nextInt();
							scanner.nextLine();
							
							System.out.print("Enter Vehicle Plate No.: ");
							String plateNumber = scanner.nextLine();
							System.out.print("Enter Start Date (dd/MM/YYYY): ");
							sDate = scanner.nextLine();
							System.out.print("Enter End Date (dd/MM/YYYY): ");
							eDate = scanner.nextLine();
							
							format = new SimpleDateFormat("dd/MM/yyyy");
							try {
								Date startDate = format.parse(sDate);
								Date endDate = format.parse(eDate);
								vehiclePark.bookVehicle(vehicleType,plateNumber,startDate, endDate,currentUser);
							} catch (ParseException e) {
								System.out.println("Invalid Date Format");
							} catch (SorryWeDontHaveThatOneException e) {
								System.out.println(e.getMessage());
							}
							break;
						case 5:
							
							System.out.println("\n==========Vehical Type Menu==========\n");
							System.out.println("1: Car");
							System.out.println("2: Truck");;
							
							
							System.out.print("\nSelect Option : ");
							vehicleType = scanner.nextInt();
							scanner.nextLine();
							
							System.out.print("Enter Vehicle Plate No.: ");
							plateNumber = scanner.nextLine();
							
							try {
								vehiclePark.cancelBooking(vehicleType, plateNumber);
								System.out.println("\nBooking canceled");
							} catch (SorryWeDontHaveThatOneException e) {
								System.out.println(e.getMessage());
							} catch (NoCancellationYouMustPayException e) {
								System.out.println(e.getMessage());
							}
							
							break;
						
						case 6:
							
							System.out.println("\n==========Vehical Type Menu==========\n");
							System.out.println("1: Car");
							System.out.println("2: Truck");;
							
							
							System.out.print("\n\nSelect Option : ");
							vehicleType = scanner.nextInt();
							scanner.nextLine();
							
							if(vehicleType==2)
							{
								System.out.println("Neither remote delivery, nor remote dropping off is possible");
							}
							else
							{
								
								System.out.print("Enter Vehicle Plate No.: ");
								plateNumber = scanner.nextLine();
								System.out.print("Enter Start Date (dd/MM/YYYY): ");
								sDate = scanner.nextLine();
								System.out.print("Enter End Date (dd/MM/YYYY): ");
								eDate = scanner.nextLine();
								System.out.print("Enter Start Location: ");
								String startLocation = scanner.nextLine();
								System.out.print("Enter End Location: ");
								String endLocation = scanner.nextLine();
								
								format = new SimpleDateFormat("dd/MM/yyyy");
								try {
									Date startDate = format.parse(sDate);
									Date endDate = format.parse(eDate);
									vehiclePark.rentVehicle(startDate, endDate, startLocation, endLocation, plateNumber, currentUser);
								} catch (ParseException e) {
									System.out.println("Invalid Date Format");
								} catch (SorryWeDontHaveThatOneException e) {
									System.out.println(e.getMessage());
								}
							}
							break;
						case 7:
							
							System.out.println("\n==========Vehical Type Menu==========\n");
							System.out.println("1: Car");
							System.out.println("2: Truck");;
							
							
							System.out.print("\n\nSelect Option : ");
							vehicleType = scanner.nextInt();
							scanner.nextLine();
							
							System.out.print("Enter Vehicle Plate No.: ");
							plateNumber = scanner.nextLine();
							
							vehiclePark.dropVehicle(vehicleType, plateNumber);
							break;
						case 8:

							break;

						default:
							break;
						}



						scanner.nextLine();
					}while(subChoice!=8);
				}
				else
				{
					System.out.println("User not fond");
				}
				scanner.nextLine();
				break;
			case 5:
				
				System.out.print("Enter user Id: ");
				String id = scanner.nextLine();
				userOp =vehiclePark.isValidUserId(id);
				if(userOp.isPresent())
				{
					currentUser = userOp.get();
					Integer subChoice;
					do
					{
						System.out.println("\n==========Sub Menu==========\n");
						System.out.println("1: Display all vehicles");
						System.out.println("2: Display available vehicles");
						System.out.println("3: Add a new vehicle to the system");
						System.out.println("4: Remove vehicle");
						System.out.println("5: Reports");
						System.out.println("6: Quit");	
						
						System.out.print("\n\nSelect Option : ");
						subChoice=scanner.nextInt();
						scanner.nextLine();
						
						switch (subChoice) {
						case 1: 
								try {
								vehiclePark.displayVehicles();
								}catch (Exception e) {
									System.out.println(e.getMessage());
								}
						
						break;
						case 2:
							System.out.print("Enter Start Date (dd/MM/YYYY): ");
							sDate = scanner.nextLine();
							System.out.print("Enter End Date (dd/MM/YYYY): ");
							eDate = scanner.nextLine();
							
							format = new SimpleDateFormat("dd/MM/yyyy");
							try {
								Date startDate = format.parse(sDate);
								Date endDate = format.parse(eDate);
								vehiclePark.displayAvailableVehicles(startDate, endDate);
							} catch (ParseException e1) {
								System.out.println("Invalid Date Format");
							} catch (SorryWeDontHaveThatOneException e) {
								System.out.println(e.getMessage());
							}
							
							break;
							
						case 3:
							System.out.println("\n==========Vehical Type Menu==========\n");
							System.out.println("1: Car");
							System.out.println("2: Truck");;
							
							
							System.out.print("\n\nSelect Option : ");
							Integer vehicleType = scanner.nextInt();
							scanner.nextLine();
							
							System.out.print("Add Vehicle Information\n");
							
							System.out.print("Enter Plate Number: ");
							String plateNumber = scanner.nextLine();

							System.out.print("Enter Number of Tires: ");
							Integer numberOfTires = scanner.nextInt();
							scanner.nextLine();
							
							System.out.print("Select Daily Fee: ");
							Integer dailyFee = scanner.nextInt();
							scanner.nextLine();
							
							switch (vehicleType) {
							case 1:
								
								System.out.print("Enter Color: ");
								String color = scanner.nextLine();
								
								System.out.print("Enter Seating Cap.: ");
								Integer seatingCap = scanner.nextInt();
								scanner.nextLine();
								System.out.print("Enter Num Of Doors: ");
								Integer numOfDoors = scanner.nextInt();
								scanner.nextLine();
								System.out.println("Car Type: 1: Sports 2: SW 3: SUV");
								System.out.print("Select Car Type: ");
								Integer carType = scanner.nextInt();
								scanner.nextLine();
								vehiclePark.addVehicle(plateNumber, numberOfTires, color, seatingCap, numOfDoors, carType, dailyFee);
								
								break;
							
							case 2:
								
								System.out.print("Enter Loading Cap: ");
								Integer loadingCap = scanner.nextInt();
								scanner.nextLine();

								System.out.println("Truck Type: 1: Small Trucks 2: Transport Trucks");
								System.out.print("\nSelect Truck Type: ");
								Integer truckType = scanner.nextInt();
								scanner.nextLine();
								vehiclePark.addVehicle(plateNumber, numberOfTires, loadingCap, truckType, dailyFee);
								
								break;

							default:
								System.out.println("Invalid vehicle type");
								break;
							}
							System.out.println("Vehicle Information Added\n");
							break;
						case 4:
							System.out.println("\n==========Vehical Type Menu==========\n");
							System.out.println("1: Car");
							System.out.println("2: Truck");;
							
							
							System.out.print("\n\nSelect Option : ");
							vehicleType = scanner.nextInt();
							scanner.nextLine();
							
							System.out.print("Enter Plate Number: ");
							plateNumber = scanner.nextLine();
							
							if(vehiclePark.removeVehicle(plateNumber, vehicleType))
								System.out.print("Vehicle Removed Information\n");
							else
								System.out.print("Vehicle Not Found\n");
							
							break;
							
						case 5:
							Date today = new Date();
							vehiclePark.dailyReport("dailyReport"+today.getDay()+today.getMonth()+today.getYear()+".txt");
							break;
							
						default:
							break;
						}
						scanner.nextLine();
					}while(subChoice!=6);
				}
				else
				{
					System.out.println("User not fond");
				}
				break;
			case 6: 
				vehiclePark.saveRegisterUser();
				System.exit(0);break;

			default:
				break;
			}

		} while (choice!=6);
		scanner.close();
	}
    
}
