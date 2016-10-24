package acm;
import java.util.Scanner;

public class TheDecoder {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		while(input.compareTo("") != 0){
			char[] inputArr = input.toCharArray();
			for(int i = 0; i < inputArr.length; i++){
				System.out.printf("%c",(char)((int)inputArr[i] - 7));
			}
			System.out.println();
			input = in.nextLine();
		}
	
	}

}
