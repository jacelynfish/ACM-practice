package acm;
import java.util.Scanner;
import java.math.BigInteger;

public class ChildAgain {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			
			BigInteger fo = in.nextBigInteger();
			String token = in.next();
			BigInteger so = in.nextBigInteger();
			BigInteger result;
			if(token.compareTo("/") == 0){
				result = fo.divide(so);
			}else{
				result = fo.mod(so);
			}
			System.out.println(result.toString());
		}
		
		
	}

}
