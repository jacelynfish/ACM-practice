package helo;

import java.math.BigInteger;
import java.util.Scanner;

public class BigNumber {
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);

		int times = in.nextInt();
		for(int i = 0; i < times; i++){
			int no = in.nextInt();
			String noStr = new Integer(no).toString();
			double count = 0;
			
			for(int j = 1; j <= no; j++){
				
				count +=Math.log10(j);
					
			}
			System.out.println((int)count+1);
						
		}
		
	}
	
}
