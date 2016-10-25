package acm;
import java.util.ArrayList;
import java.util.Scanner;

//340 - Master-Mind Hints 

public class MasterMind {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int j = 0;
		int count = in.nextInt();
		while(count != 0){
			ArrayList<Integer> nos = new ArrayList<Integer>();
			
			
			for(int i = 0; i < count; i++){
				nos.add(in.nextInt());
				
			}
			
			System.out.printf("Game %d:\n",j+1);
			
			while(true){
				ArrayList<Integer> n_clone = (ArrayList<Integer>) nos.clone();
				ArrayList<Integer> strongList = new ArrayList<Integer>();
				int strong = 0, weak = 0;
				boolean notEnd = false;
				int guess[] = new int[count];
				for(int i = 0; i < count; i++){
					guess[i] = in.nextInt();
					if(n_clone.get(i) == guess[i]){
						strong++;
						n_clone.set(i, -1);
						strongList.add(i);
					}
				}
				for(int i = 0; i < count; i++){
					if(guess[i] != 0){
						notEnd = true;
						break;
					}
				}
				if(!notEnd) break;
							
				
				for(int i = 0; i < count; i++){
					if(strongList.contains(i)){
						continue;
					}
					int item = guess[i];
					if(n_clone.contains(item)){
						int idx = n_clone.indexOf(item); 
						
						if(n_clone.get(idx) != -1) weak++;
						n_clone.set(idx, -1);
					}
					
				}
				System.out.printf("    (%d,%d)\n", strong,weak);
				
			}
			
			
			j++;
			count = in.nextInt();
			
			
			
		}
	}


}
