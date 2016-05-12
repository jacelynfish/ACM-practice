package helo;

import java.math.BigInteger;
import java.util.Scanner;

public class DigitalRoots {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		BigInteger noBig = in.nextBigInteger();
		String output = "";
		while(noBig.intValue() != 0){
			
			int root = noBig.remainder(new BigInteger("9")).intValue();
			if(root == 0){
				root = 9;
			}
			output += (root + "\n");
			
			noBig = in.nextBigInteger();
		}
		output = output.substring(0, output.length()-1);
		System.out.print(output);
	}
	
	
}
