package acm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//Uva 200 - Rare Order

public class RareOrder {
	
	public static String last, cur;
	public static HashMap<Integer, Boolean> marked;
	public static HashMap<Integer, ArrayList<Integer>> map;
	public static ArrayList<Integer> ans;
	public static ArrayList<Integer> record;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		last = in.nextLine();
		cur = in.nextLine();
		map = new HashMap<Integer, ArrayList<Integer>>();
		marked = new HashMap<Integer, Boolean>();
		ans = new ArrayList<Integer>();
		record = new ArrayList<Integer>();
		while(cur.compareTo("#") != 0){
			
			
			char[] lastArr = last.toCharArray();
			char[] curArr = cur.toCharArray();
			int minLen = (lastArr.length < curArr.length)? lastArr.length:curArr.length;
			
			for(int i = 0; i < lastArr.length; i++){
				marked.put((int)lastArr[i], false);
				
			}
			for(int i = 0; i< curArr.length; i++){
				marked.put((int)curArr[i], false);
			}
			
			for(int i = 0;i < minLen; i++){
				if(!record.contains((int)lastArr[i])) record.add((int)lastArr[i]);
				if(!record.contains((int)curArr[i])) record.add((int)curArr[i]);
				if(lastArr[i] != curArr[i]){
					ArrayList<Integer> temp;
					if(map.containsKey((int)lastArr[i])){
						temp = map.get((int)lastArr[i]);
						
					}else{
						temp = new ArrayList<Integer>();
					}
					temp.add((int)curArr[i]);
					map.put((int)lastArr[i], temp);
					

					break;
				}
			}
			last = cur;
			cur = in.nextLine();
			
		}

		
		for(int i = 0; i < record.size(); i++){
			if(!marked.get(record.get(i)))
				dfs(record.get(i));
			
				
		}
		for(int i = ans.size() - 1; i >= 0; i--){
			System.out.printf("%c",ans.get(i));
		}
		System.out.println();

		
		
	}
	
	public static void dfs(int v){
		
		marked.put(v, true);
		if(map.containsKey(v)){
			ArrayList<Integer> temp = map.get(v);
			for(int i = 0; i < temp.size(); i++){
				if(!marked.get(temp.get(i))){
					marked.put(temp.get(i), true);
					dfs(temp.get(i));
				}
			}
			
		}
		ans.add(v);
	}

}
