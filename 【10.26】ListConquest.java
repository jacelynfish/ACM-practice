package acm;

//Uva 10420 - List of Conquests

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ListConquest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int lines = Integer.parseInt(in.nextLine());
		ArrayList<String> counList = new ArrayList<String>();
		HashMap<String, ArrayList<String>> list = new HashMap<String, ArrayList<String>>();
		for(int i = 0; i < lines; i++){
			String info = in.nextLine();
			info = info.trim();
			
			int idx = info.indexOf(' ');
			String thisCoun = info.substring(0, idx);
			String girlName = info.substring(idx+1);
			
			ArrayList<String> girls;
			if(list.containsKey(thisCoun)){
				girls = list.get(thisCoun);
			}else{
				
				girls = new ArrayList<String>();
				list.put(thisCoun, girls);
				counList.add(thisCoun);
			}
			
			if(!girls.contains(girlName)) girls.add(girlName);
				
				
			
			
		}
		counList.sort(null);
		for(int i = 0; i < list.size(); i++){
			System.out.println(counList.get(i) + " " + (list.get(counList.get(i))).size());
		}
	}

}
