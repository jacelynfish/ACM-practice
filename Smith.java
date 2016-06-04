package contest1;

import java.util.ArrayList;
import java.util.Scanner;

public class Smith {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String casei = in.nextLine();
		int caseCnt = Integer.parseInt(casei);
		for(int i = 0; i < caseCnt; i++){
			String noi = in.nextLine();
			int no = Integer.parseInt(noi);
			
			
		}
		

	}
	
	public static int[] getFactors(int no){
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int sqrt = (int) Math.floor(Math.sqrt(no));
		for(int i = 1; i <= sqrt; i++){
			if(no % i == 0){
				factors.add(i);
				factors.add(no / i);
			}
		}
		int[] fac = new int[factors.size()];
		for(int i = 0; i < factors.size(); i++){
			
		}
		
	}

}
