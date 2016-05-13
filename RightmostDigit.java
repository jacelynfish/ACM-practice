package helo;

import java.math.BigInteger;
import java.util.Scanner;

public class RightmostDigit {
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int times = in.nextInt();
		for(int i = 0; i < times; i++){
			BigInteger no = in.nextBigInteger();
			int remainDigit = no.remainder(new BigInteger("4")).intValue();
			int rightMost = no.remainder(BigInteger.TEN).intValue();
			if(remainDigit == 0){
				remainDigit = 4;
			}
			int output =(int)Math.pow(rightMost, remainDigit) % 10;
			System.out.println(output);
		}
	}

}
