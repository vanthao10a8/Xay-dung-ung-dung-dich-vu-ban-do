package view;

import java.util.Random;

public class Test {
	protected String createRandomRegistryId(String handleId)
	{     
	    String val = "KH";      
	    Random r = new Random();
	    int numbers = 100000 + (int)(r.nextFloat() * 899900);
	    val += String.valueOf(numbers);
	    return val;
	}
	public static void main(String[] args) {
		int a ;
		//int b = a;
		//System.out.println(b);
		
	}
}
