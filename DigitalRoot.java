package helo;

import java.math.BigInteger;
import java.util.Scanner;

public class DigitalRoot {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		BigInteger noBig = in.nextBigInteger();
		String output = "";
		while(noBig.intValue() != 0){
			String noStr = noBig.toString();
			int[] noInts = new int[noStr.length()];
			
			for(int i = noStr.length() - 1; i >= 0; i--){
				noInts[i] = noBig.remainder(BigInteger.TEN).intValue();
				noBig = noBig.divide(BigInteger.TEN);
			}
			int root = calRoots(noInts);
			
			output += (root + "\n");
			
			noBig = in.nextBigInteger();
		}
		output = output.substring(0, output.length()-1);
		System.out.print(output);
	}
	
	public static int calRoots(int[] i){
		int sum = 0;
		int root = 0;
		for(int j = 0; j< i.length;j++){
			sum += i[j];
		}
		
		if(sum >= 10){
			Integer tempSum = new Integer(sum);
			String tempStr= tempSum.toString();
			int[] tempSumArr = new int[tempStr.length()];
			for(int k = tempSumArr.length - 1; k >= 0; k--){
				tempSumArr[k] = sum % 10;
				sum = sum /10;
			}
			root = calRoots(tempSumArr);
		}else{
			root = sum;
		}
		return root;
	}
}
