package acm;

//Uva 216 - Getting in Line

import java.util.ArrayList;
import java.util.Scanner;

public class GettingInLine {

	public static ArrayList<Dot> dots;
	public static double minLen;
	public static Dot[] curMinArr;
	public static Dot[] minArr;
	private static int docCnt;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cnt = 0;
		while(in.hasNext()){
			docCnt = in.nextInt();
			if(docCnt == 0){
				break;
			}
//			System.out.println(docCnt);
			minLen = Integer.MAX_VALUE;
			dots = new ArrayList<Dot>();
			for(int i = 0; i < docCnt; i++){
				Dot dot = new Dot(in.nextInt(), in.nextInt());
				dots.add(dot);
			}
			curMinArr = new Dot[dots.size()];
			
			backtrack(0);
			
			System.out.println("**********************************************************");
			System.out.println("Network #"+ (++cnt));
			for(int i = minArr.length - 1; i > 0; i--){
				Dot cur = minArr[i];
				Dot next = minArr[i-1];
				double xDiff = Math.pow(next.getX() - cur.getX(), 2);
				double yDiff = Math.pow(next.getY() - cur.getY(), 2);			
				double k = Math.sqrt(xDiff + yDiff) + 16;
				
				System.out.printf("Cable requirement to connect (%d,%d) to (%d,%d) is %.2f feet.\n",cur.getX(),cur.getY(),next.getX(),next.getY(),k);
			}
			System.out.printf("Number of feet of cable required is %.2f.\n",minLen);			
		}

	}
	
	
	public static void backtrack(int depth){
		
		if(depth > dots.size() - 1){
			
			calculate();
			return;
		}
		for(int i = 0; i < dots.size(); i++){
			Dot thisDot = dots.get(i);
			
			if(!thisDot.isUsed()){
				thisDot.setUsed(true);
				curMinArr[depth] = thisDot;
				backtrack(depth + 1);
				thisDot.setUsed(false);
				
			}
		}
	}
	
	public static void calculate(){
		double tLen = 0;

		for(int i = 1; i < dots.size(); i++){
			Dot next = curMinArr[i];
			Dot cur = curMinArr[i - 1];
			double xDiff = Math.pow(next.getX() - cur.getX(), 2);
			double yDiff = Math.pow(next.getY() - cur.getY(), 2);			
			tLen += Math.sqrt(xDiff + yDiff);
		}
		if(tLen + 16*(docCnt - 1) <= minLen){
			minLen = tLen + 16 * (docCnt - 1);
			minArr = curMinArr.clone();
			int j = 0;
			for(Dot a : curMinArr){
				minArr[j++] = a;
			}
		}
		
		
	}

}

class Dot {
	private int x, y;
	private boolean isUsed;
	
	public Dot(int x, int y){
		this.x = x;
		this.y = y;
		this.isUsed = false;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}