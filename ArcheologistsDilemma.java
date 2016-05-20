package hello;

import java.util.Scanner;

public class ArcheologistsDilemma {
	public static void main(String[] arg){
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()){
			String input = in.nextLine();
			if(input.compareTo("") == 0){
				break;
			}
			int n = Integer.parseInt(input);
			int i = (int)Math.log10(n) + 1;
			int m = i+1;
			while(true){
				int lower = (int)(Math.log(n)/Math.log(2) + m*Math.log(10)/Math.log(2));
				int upper = (int)(Math.log(n+1)/Math.log(2) + m*Math.log(10)/Math.log(2));
				if(upper!=lower){
					System.out.println(upper);
					break;
				}else{
					m++;
				}
			}
		}
	}

}
