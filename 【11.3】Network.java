package acm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//Uva 1267 - Network

public class Network {
	
	public static int nodeCnt, k, oriVOD;
	public static HashMap<Integer, ArrayList<Integer>> tree;
	public static HashMap<Integer, Boolean> marked;
	public static HashMap<Integer, ArrayList<Integer>> nodes;
	public static int maxDepth;
	
	public static HashMap<Integer, Integer> father;

	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int casecnt = in.nextInt();
		while(casecnt-- != 0){
			nodeCnt = in.nextInt();
			marked = new HashMap<Integer, Boolean>();
			nodes = new HashMap<Integer, ArrayList<Integer>>();
			tree = new HashMap<Integer, ArrayList<Integer>>();
			ArrayList<Integer> vodConnect = new ArrayList<Integer>();
			father = new HashMap<Integer, Integer>();
			maxDepth = Integer.MIN_VALUE;
			
			
			oriVOD = in.nextInt();
			k = in.nextInt();
			
			tree.put(oriVOD, vodConnect);
			
			for(int i = 0; i < nodeCnt-1; i++){
				int first = in.nextInt();
				ArrayList<Integer> firstList;
				int second = in.nextInt();
				ArrayList<Integer> secondList;
				if(tree.containsKey(first)){
					firstList = tree.get(first);
				}else{
					firstList = new ArrayList<Integer>();
				}
				
				if(tree.containsKey(second)){
					secondList = tree.get(second);
				}else{
					secondList = new ArrayList<Integer>();
				}
				
				firstList.add(second);
				secondList.add(first);
				tree.put(first, firstList);
				tree.put(second, secondList);
				marked.put(first, false);
				marked.put(second, false);
				
			}
			
			process(oriVOD, -1, 0);
			int ans = solve();
			System.out.println(ans);
			
		}
	}
	
	public static void process(int cur, int fa, int depth){	
		if(depth > maxDepth) maxDepth = depth;

		father.put(cur, fa);
		ArrayList<Integer> temp = tree.get(cur);
		int deg = temp.size();
		if(deg == 1 && depth > k){
			ArrayList<Integer> templ;
			if(nodes.containsKey(depth)){
				templ = nodes.get(depth);
			}else{
				templ = new ArrayList<Integer>();
			}
			templ.add(cur);
			nodes.put(depth, templ);
		}
		for(int i = 0; i < deg; i++){
			if(temp.get(i) != fa)
			process(temp.get(i), cur, depth+1);
		}
			
	}
	
	public static int solve(){
		int ans = 0;
		for(int i = maxDepth; i > k; i--){
			ArrayList<Integer> temp = nodes.get(i);
			for(int j = 0; j < temp.size(); j++){
				int a = temp.get(j);
//				System.out.println(a + " " + i);
				if(marked.get(a)) continue;
				int ance = a;
				for(int b = 0; b < k; b++) ance = father.get(ance);
				dfs(ance, -1, 0);
				
				ans++;
			}
		}
		
		return ans;
	}
	
	public static void dfs(int cur, int father, int depth){
		marked.put(cur, true);
		ArrayList<Integer> temp = tree.get(cur);
		for(int i = 0; i < temp.size(); i++){
			int a = temp.get(i);
			if(a != father && depth < k)
				dfs(a, cur, depth+1);
		}
	}

}
