package assignment3;

import java.util.StringTokenizer;

public class ElectricCar extends Car{
	private boolean isLithiumIon;
	
	//name and price constructor
	public ElectricCar(String brandName, int price) {
		super(brandName, price);
		isLithiumIon = false;
	}
	
	//parse a line from the file
	public ElectricCar(String line) {
		StringTokenizer st = new StringTokenizer(line);
		
		if(st.countTokens() >= 4) {
			//skip e
			st.nextToken();
			String brand = st.nextToken();
			setBrandName(brand);
			int price = Integer.parseInt(st.nextToken());
			setPrice(price);
			
			String batteryFlag = st.nextToken();
			isLithiumIon = batteryFlag.equals("1");
		} else {
			setBrandName("Invalid");
			setPrice(-1);
			isLithiumIon = false;
		}
	}
	
	//battery type as string
	public String batteryType() {
		if (isLithiumIon) {
			return "LithiumIon";
		} else {
			return "NickelMetal";
		}
	}
	
	//toString method
	@Override
	public String toString() {
		return ("ECar brandname: " + getBrandName() + " price: " + getPrice() + " battery: " + batteryType());
	}
	
	//getPrice method
	@Override
	public int getPrice() {
		if (isLithiumIon) {
			return (int)(super.getPrice() * 1.2);
		} else {
			return super.getPrice();
		}
	}
}
