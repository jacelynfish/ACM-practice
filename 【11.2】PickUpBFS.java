package acm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class PickUpBFS {
	public static int n;
	public static HashMap<Integer, Integer> inDeg;
	public static HashMap<Integer, ArrayList<Integer>> link;
	public static HashMap<Integer, Boolean> marked;
	public static ArrayDeque<Integer> queue;
	public static ArrayList<Integer> ans;
//	public static ArrayList<Integer> record;

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
			
			inDeg = new HashMap<Integer, Integer>();
			link = new HashMap<Integer, ArrayList<Integer>>();
			marked = new HashMap<Integer, Boolean>();
//			record = new ArrayList<Integer>();
			queue = new ArrayDeque<Integer>();
			
			while(lines-- != 0){
				String tempStr = in.nextLine();
				String tempArr[] = tempStr.split(" ");
				int top = Integer.parseInt(tempArr[0]);
				int under = Integer.parseInt(tempArr[1]);
				int ind;
				if(inDeg.containsKey(under)) ind = inDeg.get(under);
				else ind = 0;
				ind++;
				inDeg.put(under, ind);
//				if(!inDeg.containsKey(top)) inDeg.put(top, 0);
				
				ArrayList<Integer> tempList;
				if(link.containsKey(top)) tempList = link.get(top);
				else tempList = new ArrayList<Integer>();
				tempList.add(under);
				link.put(top, tempList);
				
				marked.put(top, false);
				marked.put(under, false);
//				if(!record.contains(top)) record.add(top);
//				if(!record.contains(under)) record.add(under);
			}
			
			for(int i = 1; i <= n; i++){
				if(!inDeg.containsKey(i)) inDeg.put(i, 0);
				if(inDeg.get(i) == 0){
					queue.add(i);
				}
			}
			bfs();
			
			if(ans.size() != n) System.out.println("IMPOSSIBLE");
			else{
				for(Integer k : ans)
					System.out.println(k);
			}
			info = in.nextLine();
			
			
		}
	}
	
	public static void bfs(){
		ans = new ArrayList<Integer>();
		while(!queue.isEmpty()){
			int current = queue.pop();
			ans.add(current);
			if(link.containsKey(current)){
				ArrayList<Integer> temp = link.get(current);
				for(int i = 0; i < temp.size(); i++){
					int w = temp.get(i);
					int tempdeg = inDeg.get(w);
					tempdeg--;
					inDeg.put(w, tempdeg);
					
					if(tempdeg == 0) queue.push(w);
				}
			}
		}
	}

}
