package acm;
import java.util.Scanner;
import java.math.BigInteger;

//Uva 10106

public class Product {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			String fos = in.nextLine();
			if(fos.compareTo("") == 0){
				break;
			}
			String sos = in.nextLine();
			if(sos.compareTo("") == 0){
				break;
			}
			BigInteger fo = new BigInteger(fos);
			BigInteger so = new BigInteger(sos);
			System.out.println(fo.multiply(so).toString());
		}
	}

}
