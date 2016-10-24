package acm;
import java.math.BigInteger;
import java.util.Scanner;

//Uva 465

public class Overflow {
	
	public static void main(String[] args){
		BigInteger max_int = new BigInteger(Integer.toString(Integer.MAX_VALUE));
		Scanner in = new Scanner(System.in);
		boolean fb, sb, rb;
		while(in.hasNextLine()){
			fb = false;
			sb = false;
			rb = false;
			String input = in.nextLine();
			if(input.compareTo("") == 0){
				break;
			}
			String[] inputs = input.split(" ");
			BigInteger fo = new BigInteger(inputs[0]);
			String token = inputs[1];
			BigInteger so = new BigInteger(inputs[2]);
			BigInteger result;
			if(fo.compareTo(max_int) > 0){
				fb = true;
			}
			if(so.compareTo(max_int) > 0){
				sb = true;
			}
			
			if(token.compareTo("+") == 0){
				result = fo.add(so);
			}else{
				result = fo.multiply(so);
			}

			rb = result.compareTo(max_int) > 0? true:false;
			
			System.out.println(input);
			if(fb) System.out.println("first number too big");
			if(sb) System.out.println("second number too big");
			if(rb) System.out.println("result too big");
						
		}
	}
}
