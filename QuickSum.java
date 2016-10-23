package acm;

import java.util.Scanner;

public class QuickSum {

	public static void main(String[] args) {
		String input;
		Scanner in = new Scanner(System.in);
		input = in.nextLine();
		while(input.compareTo("#") != 0){
			//A is 65
			char[] inputArr = input.toCharArray();
			int sum = 0;
			for(int i = 0; i < input.length(); i++){
				int curValue;
				if(inputArr[i] == ' '){
					curValue = 0;
				}else{
					curValue = (int)inputArr[i] - 64;
				}
				sum += (i+1)*curValue;
			}
			
			System.out.println(sum);
			input = in.nextLine();
		}

	}

}
