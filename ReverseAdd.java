package hello;

import java.math.BigInteger;
import java.util.Scanner;

public class ReverseAdd {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String caseStr = in.nextLine();
		int caseNo = Integer.parseInt(caseStr);
		for(int i = 0; i < caseNo; i++){
			StringBuilder inputStr = new StringBuilder(in.nextLine());
			int count = 0;
			BigInteger sum;
			while(!isPld(inputStr) && count <1000){
				count++;
				BigInteger pre = new BigInteger(inputStr.toString());
				BigInteger rev = new BigInteger(inputStr.reverse().toString());
				sum = pre.add(rev);
				inputStr = new StringBuilder(sum.toString());
			}
			System.out.println(count + " " + inputStr);
		}
	}
	
	public static boolean isPld(StringBuilder str){
		String oristr = str.toString();
		return oristr.compareTo(str.reverse().toString()) ==0;
	}
	
	

}
