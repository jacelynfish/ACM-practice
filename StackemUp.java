package hello;

import java.util.Scanner;

public class StackemUp {
	
	public static void main(String[] args){
		String[] values = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
		Scanner in = new Scanner(System.in);
		String caseInfo = in.nextLine();
		int caseCnt = Integer.parseInt(caseInfo);
		in.nextLine();
		for(int i = 0; i < caseCnt; i++){
			
			int time = in.nextInt();
			
			int[] afterShuffles = new int[52];
			for(int j = 0; j < 52; j++){
				afterShuffles[j] = j+1;
			}
			
			int[][] shuffles = new int[time][52];
			for(int j = 0; j < time; j++){
				for(int k = 0; k < 52; k++){
					shuffles[j][k] = in.nextInt();
				}
			}

			
			for(int j = 0; j < time; j++){
				int index = in.nextInt();
				index = index -1;
				int[] thisTime = shuffles[index];
				int[] temp = new int[52];
				for(int pos = 0; pos < 52; pos++){
					temp[pos] = afterShuffles[thisTime[pos]-1];
				}
				afterShuffles = temp;
				
			}
			
			for(int j = 0; j < 52; j++){
				String suit = suits[(afterShuffles[j]-1)/13];
				String value = values[(afterShuffles[j]-1)%13];
				System.out.println(value + " of " + suit);
			}
			if(i != caseCnt -1){
				System.out.println();
			}
			
		}
		
	}

}
