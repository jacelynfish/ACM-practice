package acm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PickUpSticks {

	public static int n;
	public static HashMap<Integer, Boolean> marked;
	public static HashMap<Integer, Boolean> onStack;
	public static HashMap<Integer, Integer> edgeTo;
	public static ArrayList<Integer> sticks;
	public static HashMap<Integer, ArrayList<Integer>> map;
	public static ArrayList<Integer> cycle;
	public static ArrayList<Integer> ans;
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String info = in.nextLine();
		while(info.compareTo("") != 0){
			String splitarr[] = info.split(" ");
			
			n = Integer.parseInt(splitarr[0]);
			int lines = Integer.parseInt(splitarr[1]);
			
			if(n == 0 && lines == 0){
				break;
			}
			
			sticks = new ArrayList<Integer>();
			map = new HashMap<Integer, ArrayList<Integer>>();
			marked = new HashMap<Integer, Boolean>();
			onStack = new HashMap<Integer, Boolean>();
			edgeTo = new HashMap<Integer,Integer>();
			ans = new ArrayList<Integer>();
			
			
			while(lines-- != 0){
				String tempStr = in.nextLine();
				String tempArr[] = tempStr.split(" ");
				int top = Integer.parseInt(tempArr[0]);
				int under = Integer.parseInt(tempArr[1]);
				if(!sticks.contains(top)) sticks.add(top);
				if(!sticks.contains(under)) sticks.add(under);
				ArrayList<Integer> link;
				if(map.containsKey(top)){
					link = map.get(top);
				}else{
					link = new ArrayList<Integer>();
				}
				link.add(under);
				map.put(top, link);
				
				//Initialized the marked array
				marked.put(top, false);
				marked.put(under, false);
				
 			}
			
			for(int i = 0; i < sticks.size(); i++){
				checkLoop(sticks.get(i));
			}
			
			if(cycle != null){
				System.out.println("IMPOSSIBLE");
			}else{
				//reinitialize the marked array
				marked = new HashMap<Integer,Boolean>();
				for(int i = 0; i< sticks.size(); i++){
					marked.put(sticks.get(i), false);
					if(map.containsKey(sticks.get(i))){
						ArrayList<Integer> temp = map.get(sticks.get(i));
						for(int j = 0; j < temp.size(); j++){
							marked.put(temp.get(j),false);
						}
					}
					
				}
				for(int i = 0; i < sticks.size(); i++){
					dfs(sticks.get(i));
				}
				for(int i = 0; i < ans.size(); i++){
					System.out.println(ans.get(i));
				}
			}
			info = in.nextLine();
		}
	}
	
	public static void checkLoop(int v){
		onStack.put(v, true);
		marked.put(v, true);
		if(map.containsKey(v)){
			ArrayList<Integer> list = map.get(v);
			for(int i = 0; i < list.size(); i++){
				int w = list.get(i);
				if(!marked.get(w)){
					edgeTo.put(w, v);
					checkLoop(w);
				}else if(onStack.get(w)){
					cycle = new ArrayList<Integer>();
					for(int x = v; x!= w; x = edgeTo.get(x) )
						cycle.add(x);
					cycle.add(w);
					cycle.add(v);
				}
			}
		}else{
			onStack.put(v, false);
			return;
		}
		onStack.put(v, false);
	}
	
	
	public static void dfs(int v){
		marked.put(v, true);
		if(map.containsKey(v)){
			ArrayList<Integer> list = map.get(v);
			for(int i = 0; i < list.size(); i++){
				int w = list.get(i);
				if(!marked.get(w)){
					checkLoop(w);
				}
//				ans.add(v);
			}
		}
//			System.out.println("not contained: "+ v);
			ans.add(v);
//			return;
		
		
	}

}
