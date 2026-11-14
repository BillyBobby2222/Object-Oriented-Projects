package assignment2;

public class DiceTester {
	public static void main(String[] args) {
		Dice dice = new Dice();
		int[] occurrences = new int[13];
		
		//roll 1000 times
		for (int i = 0; i < 1000; i++) {
			dice.roll();
			int sum = dice.getFaceValue();
			//count occurrences
			occurrences[sum]++;
		}
		
		//print out occurrences
		System.out.println("Dice Roll Results (1000 Rolls): ");
		for (int i = 2; i <= 12; i++) {
			System.out.println("Number of " + i + "s is " + occurrences[i]);
		}
		System.out.println();
		
		//start of histogram section
		System.out.println("Histogram:      Sum of Two Dice\n");
		
		//print y-axis
		for (int y = 175; y >= 0; y -= 25) {
			
			//y-axis numbers
			if (y < 100 && y >= 25) {
				System.out.print(" " + y + "|");
			} else if (y < 25){
				System.out.print("  " + y + "|");
			} else {
				System.out.print(y + "|");
			}
			
			//bars for each occurrence
			for (int sum = 2; sum <= 12; sum++) {
				if (occurrences[sum] >= y) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
		
		//x-axis line
		System.out.print("     ");
		for (int i = 2; i <= 12; i++) {
			System.out.print("---");
		}
		System.out.println();
		
		//print x-axis
		System.out.print("     ");
		for (int o = 2; o <= 12; o++) {
			if (o < 10) {
				//single digit followed by 2 spaces
				System.out.print(o + "  ");
			} else {
				//double digit followed by 1 space
				System.out.print(o + " ");
			}
		}
	}
}
