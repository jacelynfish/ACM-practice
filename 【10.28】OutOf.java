package acm;

import java.util.Scanner;

//10344 - 23 out of 5 参考解题报告 http://www.cppblog.com/rakerichard/archive/2010/01/10/105323.html

public class OutOf {

	public static boolean possible;
	public static int[] pairs;
	public static int[] nums;
	public static boolean[] used;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			possible = false;
			nums = new int[5];
			used = new boolean[5];
			pairs = new int[5];
			boolean isEnd = true;
			for(int i = 0; i < 5; i++){
				nums[i] = in.nextInt();
				used[i] = false;
			}
			for(int i = 0; i < 5; i++){
				if(nums[i] != 0){
					isEnd = false;
					break;
				}
			}
			if(isEnd) break;
			backtrack1(0);

			if(possible) System.out.println("Possible");
			else System.out.println("Impossible");
			
		}

	}
	
	public static void backtrack1(int depth){
				
		if(possible) return;

		if(depth > 4){
			backtrack2(1, pairs[0]);
			return;
		}
		for(int i = 0; i < 5; i++){
			if(!used[i]){
				used[i] = true;
				pairs[depth] = nums[i];
				backtrack1(depth + 1);
				used[i] = false;
			}
		}
		
	}
	
	public static void backtrack2(int depth, int current){
		if(possible) return;
		if(depth > 4){
			if(current == 23){
				
				possible = true;
				
			}
			return;
		}
		backtrack2(depth+1, current+pairs[depth]);
		backtrack2(depth+1, current-pairs[depth]);
		backtrack2(depth+1, current*pairs[depth]);
	}

}
