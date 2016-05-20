package hello;

import java.math.BigInteger;
import java.util.Scanner;

public class Ones {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			String str = in.nextLine();
			if(str == null){
				break;
			}
			BigInteger no = new BigInteger(str);
			int i = 0;
			BigInteger k = BigInteger.ONE;
			BigInteger ten = BigInteger.TEN;
			while(true){
				
				if(k.remainder(no).equals(BigInteger.ZERO)){
					System.out.println(i+1);
					break;
				}else{
					i++;
					k = k.add(ten.pow(i));
					continue;
				}
			}
			
		}
	}

}
