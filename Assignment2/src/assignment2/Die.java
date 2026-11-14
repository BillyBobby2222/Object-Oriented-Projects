package assignment2;
	
public class Die {
	private int faceValue;
	
	//initialize faceValue to 1
	public Die() {
		faceValue = 1;
	}
	
	//getter method
	public int getFaceValue() {
		return faceValue;
	}
	
	//setter method
	public void setFaceValue(int v) {
		faceValue = v;
	}
	
	//roll random between 1-6
	public void roll() {
		faceValue = (int)(Math.random() * 6) + 1;
	}
}
