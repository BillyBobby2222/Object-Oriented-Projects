package assignment3;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class CarDataProcess {

	//total of car prices
	public int getTotal(ArrayList<Car> arr) {
		int total = 0;
		for (Car car: arr) {
			total += car.getPrice();
		}
	return total;
	}
	
	//print car details
	public void printCars(ArrayList<Car> arr) {
		for (Car car: arr) {
			System.out.println(car.toString());
		}
	}
	
	//scan data from file to ArrayList
	public ArrayList<Car> readIntoArrayList(String fname){
		ArrayList<Car> carList = new ArrayList<>();
		
		try {
			File file = new File(fname);
			Scanner s = new Scanner(file);
			
			while (s.hasNextLine()) {
				String line = s.nextLine().trim();
				
				if (line.isEmpty()) {
					continue;
				}
				char carType = line.charAt(0);
				
				if (carType == 'e') {
					carList.add(new ElectricCar(line));
				} else if (carType == 'g') {
					carList.add(new Car(line));
				}
			}
			s.close();
		} catch (Exception e) {
			//file exists
		}
		return carList;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CarDataProcess processor = new CarDataProcess();
		System.out.print("Enter the file name: ");
		String fileName = input.nextLine();
		
		//read file data
		ArrayList<Car> cars = processor.readIntoArrayList(fileName);
		
		//print all cars
		processor.printCars(cars);
		
		//total price calc and display
		int totalPrice = processor.getTotal(cars);
		System.out.println("Total price of all cars: " + totalPrice);
		
		input.close();

	}

}
