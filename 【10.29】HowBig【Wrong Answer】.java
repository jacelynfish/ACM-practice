package acm;

import java.util.Scanner;

//Uva 10012 - How Big Is It? 【Wrong answer 实在没思路了】

public class HowBig {

	public static int cCnt;
	public static double[] circles;
	public static double[] newP;
	public static boolean[] marked;
	public static double minLen;
	public static boolean isLastTotal;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner in = new Scanner(System.in);
		int caseCnt = Integer.parseInt(in.nextLine());
		while(caseCnt-- != 0){
			cCnt = in.nextInt();
			minLen = Double.MAX_VALUE;
			circles = new double[cCnt];
			marked = new boolean[cCnt];
			newP = new double[cCnt];
			for(int i = 0; i < cCnt; i++){
				circles[i] = in.nextDouble();
				marked[i] = false;
			}
			
			backtrack(0);
			System.out.printf("%.3f\n", minLen);
		}

	}
	
	public static void backtrack(int depth){
		if(depth > cCnt - 1){
			calculate();
			return;
		}
		for(int i = 0; i < cCnt; i++){
			if(!marked[i]){
				marked[i] = true;
				newP[depth] = circles[i];
				backtrack(depth + 1);
				marked[i] = false;
				
			}
		}
	}
	
	public static void calculate(){
		double len = newP[0];
		double totalLen = len*2;
		double lastTotalRadius = newP[0];
		double lastTotalCircle = newP[0];
		for(int i = 1; i < cCnt; i++){
//			System.out.println("last total Radius: " + lastTotalRadius);
//			System.out.println("last total circle: " + lastTotalCircle);
			
			double j = Math.pow(Math.abs(newP[i] + lastTotalCircle), 2);
			double k = Math.pow(Math.abs(newP[i] - lastTotalCircle), 2);
			len = Math.sqrt(j - k);
			double preLen = (totalLen < newP[i]?newP[i]*2:totalLen);
//			System.out.println("smaller");
//			System.out.println(totalLen > totalLen-lastTotalRadius+len+newP[i]);
//				System.out.println("len: "+len+" totalLen: "+ totalLen +" totalLen-lastTotalRadius+len+newP[i]: " +(totalLen-lastTotalRadius+len+newP[i]));
			totalLen = Math.max(preLen, preLen-lastTotalRadius+len+newP[i]);
//			totalLen = Math.max(preLen, totalLen);
			if(preLen <= preLen-lastTotalRadius+len+newP[i]){

				lastTotalRadius = newP[i];
				lastTotalCircle = newP[i];
			}
			
			
			
		}
			
//		}
//		System.out.println("last total Radius: " + lastTotalRadius);
//		System.out.println("last total circle: " + lastTotalCircle);
//		double totalLen = 0;
//		if(((Math.pow(2*newP[0], 2)-Math.PI*Math.pow(newP[0],2)) / 4 < Math.PI * Math.pow(newP[1], 2))){
//			totalLen += newP[0];
//		}
//		
//		if(((Math.pow(2*newP[newP.length - 1], 2)-Math.PI*Math.pow(newP[newP.length - 1],2)) / 4 < Math.PI * Math.pow(newP[newP.length - 2], 2))){
//			totalLen += newP[newP.length - 1];
//		}
//		
//		for(int i = 0; i < cCnt - 1; i++){
//			double add = 0;
//			if(((Math.pow(2*newP[i], 2)-Math.PI*Math.pow(newP[i],2) )/ 4 > Math.PI * Math.pow(newP[i+1], 2))){
//				add = newP[i];
////				System.out.println(("***1: "+(Math.pow(2*newP[i], 2)-Math.PI*Math.pow(newP[i],2) / 4) + " ***2:"+ (Math.PI * Math.pow(newP[i+1], 2))));
//				
//				System.out.println("bigger");
//			}else{
//				double j = Math.pow(Math.abs(newP[i] + newP[i+1]), 2);
//				double k = Math.pow(Math.abs(newP[i] - newP[i+1]), 2);
//				add = Math.sqrt(j - k);
//				System.out.println("smaller");
//			}
//			
//			totalLen += add;
//			
//		}
//		for(double k : newP) System.out.println(k);
//		System.out.println(totalLen);
//		System.out.println("***");
		if(totalLen < minLen){
			
			minLen = totalLen;
		}
	}

}
