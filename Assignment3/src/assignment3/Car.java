package assignment3;

import java.util.StringTokenizer;

public class Car {
	private String brandName;
	private int price;
	
	//constructor with variables
	public Car(String brandName, int price) {
		this.brandName = brandName;
		this.price = price;
	}
	
	//parse a line from the file
	public Car(String line) {
		StringTokenizer st = new StringTokenizer(line);
		
		if(st.countTokens() >= 3) {
			st.nextToken();
			brandName = st.nextToken();
			price = Integer.parseInt(st.nextToken());
		} else {
			brandName = "Invalid";
			price = -1;
		}
	}
	
	//default constructor
	public Car() {
		brandName = "Invalid";
		price = -1;
	}
	
	//price getter
	public int getPrice() {
		return price;
	}
	
	//price setter
	public void setPrice(int price) {
		this.price = price;
	}
	
	//brand name getter
	public String getBrandName() {
		return brandName;
	}
	
	//brand name setter
	public void setBrandName(String name) {
		brandName = name;
	}
	
	//toString method
	@Override
	public String toString() {
		return ("GCar brandname: " + brandName + " price: " + price);
	}
	
}
