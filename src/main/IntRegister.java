package main;

public class IntRegister {

	public static int number=0;
	String name;
	int value;
	String qj;
	public IntRegister(int value) {
		name="R"+number;
		this.value=value;
		number++;
	}
	
}
