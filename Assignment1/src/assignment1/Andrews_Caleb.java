/*

Caleb Andrews

PID:5634333

NID:ca298763

This program is done for COP3330 course at year 2025. This program created a formatted receipt.

*/
package assignment1;

import java.util.Random;
import java.util.Scanner;
public class Andrews_Caleb{

	public static void main(String[] args) {
		//make random and scanner
		Random r = new Random();
		Scanner scan = new Scanner(System.in);
		//generate receipt number
		int receiptNumber = r.nextInt(1000)+1000;
		
		//print header for receipt and number
		System.out.println("******************************");
		System.out.println("***********Store C************");
		System.out.println("******************************");
		System.out.println("receipt number      " + receiptNumber);

		//get date for receipt
		System.out.println(generateDate());
		
		//total number and price with temporary price variable
		int num = 0;
		double price = 0.00;
		double total = 0.00;
		
		//create user input variable
		String word = "";
		System.out.print("Write item name ");
		word = scan.next();
		//make first letter uppercase
		word = word.substring(0, 1).toUpperCase() + word.substring(1);
		
		//loop for getting items and price
		while (!word.equals("DONE")) {
			//add for each item
			num += 1;
			System.out.print("Write price ");
			
			//check if item is taxable
			if (word.equals("Food") || word.equals("food")){
				//if food, no tax
				price = scan.nextDouble();
			} else {
				//if not food, tax
				price = scan.nextDouble() * 1.3;
			}
			//add price to total
			total += price;
			
			//printing the number, item, and price
			System.out.println("item number " + num + " " + word + " " + String.format("%,.2f", price));
			
			//start loop over 
			System.out.print("Write item name ");
			word = scan.next();
			word = word.substring(0, 1).toUpperCase() + word.substring(1);
			
		}
		//printing the end of the receipt
		System.out.println(num + " items      total " + String.format("%,.2f", total));
		
		//receipt footer
		System.out.println("******************************");
		System.out.println("******************************");
		System.out.println("******************************");
		
		scan.close();
	}
	
	public static String generateDate() {
		Random r = new Random();
		
		//array of months to choose from
		String[] months = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String month = months[r.nextInt(12)];
		
		//random day between 1 and 28
		int dayOfMonth = r.nextInt(28)+1;
		String day = String.format("%02d", dayOfMonth);
		
		//random year between 1900 and 2099
		int year = r.nextInt(200)+1900;
		
		//return total day
		return month + " " + day + " " + year;
		
		
	}

}
