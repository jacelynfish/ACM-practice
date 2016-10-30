package acm;

import java.util.Scanner;

//Uva 639 - Don't Get Rooked

public class Rooked {

	public static int[][] chess;
	public static int[][] place;
	public static boolean[][] marked;
	public static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static int dot = (int)'.';
	public static int wall = (int)'X';
	
	public static int max;
	public static int cnt;
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		cnt = Integer.parseInt(in.nextLine());
		while(cnt != 0){
			max = Integer.MIN_VALUE;
			place = new int[cnt][cnt];
			chess = new int[cnt][cnt];
			marked = new boolean[cnt][cnt];
			for(int i = 0;i < cnt; i++){
				String k = in.nextLine();
				char[] krr = k.toCharArray();
//				for(char kk : krr) System.out.print(kk);
//				System.out.println();
				for(int j = 0; j < cnt; j++){
					chess[i][j] = (int)krr[j];
					place[i][j] = 0;
					marked[i][j] = false;
				}
			}
			
			backtrack(0, 0);
			System.out.println(max);

			cnt = Integer.parseInt(in.nextLine());
			
		}
	}
	
	public static void backtrack(int x, int count){
		for(int i = x; i < cnt; i++){
			for(int j = 0; j < cnt; j++){
				if(!marked[i][j] && chess[i][j] == dot && !isConflict(i, j)){
					marked[i][j] = true;
					backtrack(i, count+1);
					marked[i][j] = false;
				}
			}
		}
		
		
		if(count > max){
			max= count;

		}
	}
	
	public static boolean isConflict(int i, int j){
		for(int k = 0; k < 4; k++){
			int dx = i + dir[k][0];
			int dy = j + dir[k][1];
			while(dx >= 0 && dx < cnt && dy >= 0 && dy < cnt){

				if(chess[dx][dy] == wall){
					break;
				}
				if(marked[dx][dy]){
					return true;

				}
				dx += dir[k][0];
				dy += dir[k][1];
			}
		}
		return false;
	}

}
