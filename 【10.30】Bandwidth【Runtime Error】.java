package acm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Bandwidth {
	
	public static char[] list;
	public static boolean[] marked;
	public static char[] current;
	public static char[] saved;
	public static int minWidth;
	public static HashMap<Character, ArrayList<Character>> vMap;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String info = in.nextLine();
		while(info.compareTo("#") != 0){
			String[] infos = info.split(";");

			vMap = new HashMap<Character, ArrayList<Character>>();

			ArrayList<Character> tempArr = new ArrayList<Character>();

			
			for(int i = 0; i < infos.length; i++){
				
				String[] temp = infos[i].split(":");
				char curChar = temp[0].charAt(0);
				ArrayList<Character> tempList;
				if(!tempArr.contains(curChar)){
					tempArr.add(curChar);
					tempList = new ArrayList<Character>();
					
				}else{
					tempList = vMap.get(curChar);
				}
				
				 
				for(int j = 0; j < temp[1].length(); j++){
					char thisChar = temp[1].charAt(j);
					if(!tempList.contains(thisChar)){
						tempList.add(thisChar);
					}
					
					
					ArrayList<Character> temparr;
					if(!tempArr.contains(thisChar)){
						tempArr.add(thisChar);
						 temparr = new ArrayList<Character>();
						
					}else{
						temparr = vMap.get(thisChar);
					}
					if(!temparr.contains(curChar)) temparr.add(curChar);

					vMap.put(thisChar, temparr);
					
				}

				vMap.put(curChar, tempList);

			}
			
			int size = tempArr.size();
			list = new char[size];
			marked = new boolean[size];
			minWidth = Integer.MAX_VALUE;
			current = new char[size];
//			saved = new char[size];
			for(int i = 0; i < tempArr.size(); i++){
				list[i] = tempArr.get(i);
				marked[i] = false;
			}
			
//			tempArr.sort(null);
//			for(int i = 0; i< tempArr.size(); i++){
//				saved[saved.length - i -1] = tempArr.get(i);
//			}
			saved = list.clone();

			backtrack(0);
			for(int i = 0; i < saved.length; i++){
				System.out.print(saved[i] + " ");
			}
			System.out.println("-> "+ minWidth);
			info = in.nextLine();
		}
	}
	
	public static void backtrack(int depth){
		if(depth > list.length - 1){

			calculate();
			return;
		}
		for(int i = 0; i< list.length; i++){
			if(!marked[i]){
				marked[i] = true;
				current[depth] = list[i];
				backtrack(depth + 1);
				marked[i] = false;
			}
		}
		
	}
	
	public static void calculate(){
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < current.length; i++){
			char key = current[i];
			ArrayList<Character> value = vMap.get(key);
			for(int j = 0; j < value.size(); j++){
				char nKey = value.get(j);
				int nPos = find(nKey);
				int diff = Math.abs(nPos - i);
				if(diff > max) max = diff;

			}
		}
		
		if(max <= minWidth) {

			if(max == minWidth){
				if(isLexSmaller(current, max)){

				saved = current.clone();
			}
			}else{
				saved = current.clone();
			}
			minWidth = max;			
			
		}
		
	}
	
	public static boolean isLexSmaller(char[] current, int max){
		
		String curStr = new String(current);
		String savedStr = new String(saved);

		return curStr.compareTo(savedStr) < 0;
	}
	
	public static int find(char key){
		for(int i = 0; i < current.length; i++){
			if(current[i] == key){
				return i;
			}
		}
		return -1;
	}

}
