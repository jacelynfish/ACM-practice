package acm;
//Uva 424	Integer Inquiry
import java.math.BigInteger;
import java.util.Scanner;

public class IntegerInquiry {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String fos = in.nextLine();
		BigInteger fo = new BigInteger(fos);
		BigInteger result = fo;
		while(fo.compareTo(BigInteger.ZERO)!= 0){

			String sos = in.nextLine();
			BigInteger so = new BigInteger(sos);
			result = result.add(so);
			fo = so;
		}
		System.out.println(result.toString());
	}

}
