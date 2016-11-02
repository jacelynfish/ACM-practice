package acm;

import java.util.Scanner;

public class ThickestBurger {
	public static int max;
	public static int threeA, threeB;
	public static int meat[];
	public static int list[];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int casecnt = Integer.parseInt(in.nextLine());
		while(casecnt-- != 0){
			max = Integer.MIN_VALUE;
			list = new int[2];
			list[0] = in.nextInt();
			list[1] = in.nextInt();
			meat = new int[3];
			threeA = list[0] * 3;
			threeB = list[1] * 3;
			
			backtract(0);
			System.out.println(max);

			
		}

	}
	
	public static void backtract(int num){
		if(num > 2){
			
			int sum = 0;
			for(int i = 0; i < meat.length; i++){
				sum += meat[i];
			}
			if(!(sum == threeA || sum == threeB)){
				if(sum > max) max = sum;
				
				return;
			}
			return;
		}
		for(int i = 0;i < 2; i++){

				meat[num] = list[i];
				backtract(num+1);				

		}
	}

}
