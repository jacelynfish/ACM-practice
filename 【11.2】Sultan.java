package acm;

import java.util.Scanner;

//Uva 167 - The Sultan's Successors

public class Sultan {
	
	public static int chess[][];
	public static boolean marked[][];
	public static int max;
	public static int dir[][] = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int caseCnt = Integer.parseInt(in.nextLine());
		while(caseCnt-- != 0){
			chess = new int[8][8];
			marked = new boolean[8][8];
			max = Integer.MIN_VALUE;
			
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					chess[i][j] = in.nextInt();
					marked[i][j] = false;
				}
			}
			
			backtrack(0, 0, 0);
			System.out.printf("%5d\n", max);
			
		}
	}
	
	public static void backtrack(int x, int sum, int num){

		for(int i = x; i < 8; i++){
			
			for(int j = 0; j < 8; j++){
			
				if(!marked[i][j] && !isConflict(i, j)){
					marked[i][j] = true;
					backtrack(i+1,sum+chess[i][j], num+1);
					marked[i][j] = false;
				}
			}
		}
		if(num == 8 && sum > max) {
			max = sum;

		}
	}
	
	public static boolean isConflict(int i, int j){
		for(int k = 0; k < 8; k++){
			int dx, dy;
			
			dx = i + dir[k][0];
			dy = j + dir[k][1];
			
			while(dx >= 0 && dx < 8 && dy >= 0 && dy < 8){
				if(marked[dx][dy]) return true;
				
				dx += dir[k][0];
				dy += dir[k][1];
				
			}
		}
		
		return false;
	}

}
