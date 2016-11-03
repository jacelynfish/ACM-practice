package acm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Uva 10034 - Freckles

public class Freckles {
	
	public static HashMap<Freckle, ArrayList<Edge>> map;
	public static HashMap<Freckle, Boolean> marked;
	public static ArrayList<Freckle> record;
	public static PriorityQueue<Edge> pq;
	public static HashMap<Freckle, Edge> edgeTo;
	public static HashMap<Freckle, Double> distTo;

	public static void main(String[] args) {

		EdgeCompare edgeCompare = new EdgeCompare();
		
		Scanner in = new Scanner(System.in);
		int casecnt = in.nextInt();
		while(casecnt-- != 0){
			in.nextLine();
			
			map = new HashMap<Freckle, ArrayList<Edge>>();
			marked = new  HashMap<Freckle, Boolean>();
			record = new ArrayList<Freckle>();
			pq = new PriorityQueue<Edge>(edgeCompare);
			edgeTo = new HashMap<Freckle, Edge>();
			distTo = new HashMap<Freckle, Double>();
			
			
			int dotcnt = in.nextInt();
			for(int i = 0; i < dotcnt; i++){
				double x = in.nextDouble();
				double y = in.nextDouble();
				Freckle temp = new Freckle(x, y);
				record.add(temp);
				marked.put(temp, false);
				
			}
			
			for(int i = 0; i < record.size(); i++){
				ArrayList<Edge> edgeList;
				Freckle key = record.get(i);
				if(map.containsKey(key)) edgeList = map.get(key);
				else edgeList = new ArrayList<Edge>();
				
				for(int j = 0; j < record.size(); j++){
					if(j == i) continue;
					Edge newEdge = new Edge(key, record.get(j));
					edgeList.add(newEdge);
					map.put(key, edgeList);
				}
				distTo.put(key, Double.MAX_VALUE);
			}
			
			
			
			Edge initialEdge = new Edge(record.get(0), record.get(0));
			pq.add(initialEdge);
			distTo.put(record.get(0), 0.0);
			edgeTo.put(record.get(0), initialEdge);
			marked.put(record.get(0), true);
			
			while(!pq.isEmpty()){
				visit(pq.poll());
			}
			
			double total = 0.0;
			for(int i = 1; i < record.size(); i++){
				total += edgeTo.get(record.get(i)).weight;
			}
			System.out.printf("%.2f\n",total);
			if(casecnt != 0){
				System.out.println();
			}
		}
	}
	
	public static void visit(Edge e){
		marked.put(e.w, true);//下一轮传进来的时候，其实是传进来上一轮的edge,所以要马克定点的话，就要马克上一轮的w
		ArrayList<Edge> tempEdge = map.get(e.w);
		for(int i = 0; i< tempEdge.size(); i++){
			Edge ed = tempEdge.get(i);
			Freckle w = ed.other(e.w);
			if(marked.get(w)) continue;
			if(ed.weight < distTo.get(w)){
				edgeTo.put(w, ed);
				distTo.put(w, ed.weight);
				Iterator<Edge> pqi = pq.iterator();
				while(pqi.hasNext()){
					Edge k = pqi.next();
					if(k.w.isEqualto(w)){
						pq.remove(k);
						break;
					}
				}
				
				pq.add(ed);
			}
			
		}
	}
	

}

class Freckle{
	public double x, y;
	public Freckle(double x, double y){
		this.x = x;
		this.y = y;
	}
	public boolean isEqualto(Freckle another){
		if(this.x == another.x && this.y == another.y){
			return true;
		}
		return false;
	}


	
}

class Edge{
	public Freckle v, w;
	public double weight;
	public Edge(Freckle v, Freckle w){
		this.v = v;
		this.w = w;
		this.weight = Math.sqrt(Math.pow(v.x-w.x, 2) + Math.pow(v.y - w.y, 2));
	}
	
	public Freckle other(Freckle a){
		if(a.isEqualto(this.v)) return w;
		else if(a.isEqualto(this.w)) return v;
		else return null;
	}
	
	public boolean equals(Edge other){
		if(this.v.isEqualto(other.v) && this.w.isEqualto(other.w)){
			return true;
		}else{
			return false;
		}
	}
}

class EdgeCompare implements Comparator<Edge>{

	@Override
	public int compare(Edge a, Edge b) {
		double diff = a.weight - b.weight;
		int k;
		if(diff < 0) k = -1;
		else if(diff == 0) k = 0;
		else k = 1;
		return k;
	}

	
	
}
