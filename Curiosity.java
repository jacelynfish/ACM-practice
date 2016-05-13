package helo;

import java.util.Scanner;

public class Curiosity {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int block = in.nextInt();
		
		for(int i = 0; i < block; i++){
			int n = in.nextInt();
			int m = in.nextInt();
			int caseCount = 0;
			String output = "";
			while(n != 0){
				
				caseCount++;
				int count = 0;
				for(int j = 1; j < n; j++){
					for(int k = j+1; k < n; k++){
						if(j < k &&( (Math.pow(j, 2)+Math.pow(k, 2) + m) % (j*k) ==0)){
							count++;
						}
					}
				}
				System.out.print("Case "+ caseCount + ": " + count + "\n");
				
				n = in.nextInt();
				m = in.nextInt();
				
			}
			if(i != block -1){
				System.out.println();
			}
			
			
		}
		
	}

}
