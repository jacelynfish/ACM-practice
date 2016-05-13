package helo;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeRing {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			int times = in.nextInt();
			int[] naturalNo = new int[times];
			int[] sortedNo = new int[times];
			boolean[] isMarked = new boolean[times];
			for(int i = 0; i< times; i++){
				naturalNo[i] = i+1;
				isMarked[i] = false;
			}
			
			sortedNo[0] = 1;
			
			int count = 0;
			dfs(naturalNo,sortedNo,isMarked,0,count);
			print(sortedNo);
		}
		
		

	}
	
	public static void dfs(int[] naturalNo, int[] sortedNo, boolean[] isMarked,int initNo,int count){
		
		isMarked[initNo] = true;
		count++;
		
		if(count == sortedNo.length){
			if(isPrime(naturalNo[initNo]+sortedNo[0])){
				sortedNo[sortedNo.length-1] = naturalNo[initNo];
				return;
				
			}
		}
		for(int i = 0; i < sortedNo.length;i++){
				if(!isMarked[i] && isPrime(naturalNo[initNo] + naturalNo[i])){
					sortedNo[count - 1] = naturalNo[initNo];
					
					dfs(naturalNo,sortedNo,isMarked,i,count);
					isMarked[i] = false;

				}else{
					continue;
				}
			
			
		}

	}
	
	public static boolean isPrime(int i){
		ArrayList<Integer> factor = new ArrayList<Integer>();
		int root = (int) Math.floor(Math.sqrt(i));
		for(int k = 1; k <= root;k++){
			if(i % k == 0){
				factor.add(k);
				if(k == root && root == Math.sqrt(i)){
					continue;
				}else{
					factor.add(i/k);
				}
			}else{
				continue;
			}
		}
		
		int len = factor.size();
//		for(int no : factor){
//			System.out.print(no + " ");
//		}
		if(len == 2){
			return true;
		}else{
			return false;
		}
	}
	
	public static void print(int[] sortedNo){
		System.out.print(sortedNo[0] + " ");
		for(int i = sortedNo.length-1; i > 0; i--){
			System.out.print(sortedNo[i] + (i == 1 ? "":" "));
		}
		System.out.println();
		for(int i = 0; i < sortedNo.length; i++){
			System.out.print(sortedNo[i] + (i == sortedNo.length-1 ? "":" "));
		}
		System.out.println();
		System.out.println();
		
	}

}
