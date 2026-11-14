package assignment4;

import java.util.Scanner;

public class LinkedListTester {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//ask and get file name
		System.out.print("Enter file name: ");
		String fname = input.nextLine();
		
		LinkedList list = new LinkedList();
		
		//build list from file
		list.construct(fname);
		//run list shrink process
		list.process();
		
		//output file
		String outputFile = "processed" + fname;
		list.printToFile(outputFile);
		
		System.out.println("Processed file created: " + outputFile);
		
		input.close();
	}

}
