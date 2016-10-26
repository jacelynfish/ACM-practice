package acm;

//Uva 10474 - Where is the Marble? Most simple way of sorting and searching but time limit exceeded????

import java.util.ArrayList;
import java.util.Scanner;

public class Marbles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int stoneCnt = in.nextInt();
		int queryCnt = in.nextInt();
		int count = 0;
		while(stoneCnt != 0 && queryCnt != 0){
			System.out.println("CASE# "+ (count +1) + ":");
			ArrayList<Integer> stones = new ArrayList<Integer>();
			for(int i = 0; i < stoneCnt; i++){
				stones.add(in.nextInt());
			}
			stones.sort(null);
			for(int i = 0; i < queryCnt; i++){
				int q = in.nextInt();
				if(stones.contains(q)){
					System.out.println(q + " found at " + (stones.indexOf(q)+1));
				}else{
					System.out.println(q + " not found");
				}
			}
			stoneCnt = in.nextInt();
			queryCnt = in.nextInt();
			count++;
		}
		
	}

}
