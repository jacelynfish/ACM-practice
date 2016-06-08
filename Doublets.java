package hello;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Doublets {
	
	public static void main(String[] arg){
		Scanner in = new Scanner(System.in);
		HashMap<String,Stack<String>> map = new HashMap<String, Stack<String>>();
		String prev = "";
		ArrayList<String> words = new ArrayList<String>();
		while(in.hasNextLine()){
			prev = in.nextLine();
			if(prev.compareTo("") == 0){
				break;
			}
			words.add(prev);
		}
		String[] wordArr = new String[words.size()];
		Iterator<String> wi = words.iterator();
		int i = 0;
		while(wi.hasNext()){
			wordArr[i] = wi.next();
			i++;
		}
		
		for(int j = 0; j< wordArr.length; j++){
			String pre = wordArr[j];
			char[] preArr = pre.toCharArray();
			Stack<String> preStack;
			if(map.containsKey(pre)){
				preStack = map.get(pre);
			}else{
				preStack = new Stack<String>();
			}
			
			if(map.isEmpty()){
				map.put(pre,preStack);
			}else{
				for(int t = 0; t< wordArr.length;t++){
					if(wordArr[t].compareTo(pre)==0){
						break;
					}

					String key = wordArr[t];
					Stack<String> keyStack = map.get(wordArr[t]);
					char[] keyArr = key.toCharArray();
					int dif = 0;
					int minLen = Math.min(key.length(), pre.length());
					for(int k = 0; k < minLen; k++){
						if(preArr[k] != keyArr[k]){
							dif++;
						}
					}
					
					if(dif == 1){
						preStack.add(key);
						keyStack.add(pre);
						
					}
					map.put(pre, preStack);
					map.put(key, keyStack);
				}
			}
		}
		
//		for(Map.Entry<String, Stack<String>> entry : map.entrySet()){
//			System.out.println(entry.getKey() + " is one different to: ");
//			for(String kkk : entry.getValue()){
//				System.out.println(kkk);
//			}
//		}

		String pair = "";
		while(in.hasNextLine()){
			pair = in.nextLine();
			if(pair.compareTo("") == 0){
				break;
			}
			
			String[] pairs = pair.split(" ");
			String start = pairs[0];
			String end = pairs[1];
			
			HashMap<String, String> pathTo = bfs(map,start,end);

			if(pathTo.size() == 0){
				System.out.println("No solution.");
				continue;
			}
			
			String n = start;
			System.out.println(n);
			while(pathTo.containsKey(n)){
				n = pathTo.get(n);
				System.out.println(n);
				
				if(n.compareTo(end) == 0){
					System.out.println();
					break;
				}
			}
			
//			for(Map.Entry<String, String> entry : pathTo.entrySet()){
//				System.out.println(entry.getKey() + " " + entry.getValue());
//			}
			
		}
		
	}
	
	
	public static HashMap<String,String> bfs(HashMap<String, Stack<String>> map, String start, String end){
		HashMap<String, Boolean> marked = new HashMap<String,Boolean>();
		marked.put(start, true);
		ArrayDeque<String> queue = new ArrayDeque<String>();
		queue.push(start);
		HashMap<String,String> pathTo = new HashMap<String, String>();
		
		while(!queue.isEmpty()){
			String v = queue.poll();
			Stack<String> vStack = map.get(v);
			Iterator<String> vIterator = vStack.iterator();
			if(!vIterator.hasNext()){
				continue;
			}
//			System.out.println(v + " v");
			while(vIterator.hasNext()){
				String w = vIterator.next();
//				System.out.println(w + " w");
				
				if(!marked.containsKey(w)){
					
					marked.put(w, true);
					
					pathTo.put(v, w);
					
					queue.push(w);
				}
				
			}
		}
		
		return pathTo;
	}

}
	