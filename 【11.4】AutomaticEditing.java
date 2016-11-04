package acm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

//Uva 10115 - Automatic Editing ¡¾Accepted¡¿

public class AutomaticEditing {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		
		String str[], rep[], input;
		int casecnt = Integer.parseInt(in.nextLine());
		while(casecnt != 0){
			str = new String[casecnt];
			rep = new String[casecnt];
			
			for(int i = 0; i< casecnt; i++){
				str[i] = in.nextLine();
				rep[i] = in.nextLine();
				
			}
			
			input = in.nextLine();
			
						
			for(int i = 0, cur = 0, next = 0; i < casecnt; i++){
				for(int j = 0; input.length() > 0; j++){
					int idx = input.indexOf(str[i],0);
					if(idx < 0) break;
					cur = idx;
					next = idx + str[i].length();
					
					String tempbefore = input.substring(0, idx);
					String tempafter = input.substring(next);
					input = tempbefore + rep[i] + tempafter;
					
					cur = next + 1;
				}
			}
			
			System.out.println(input);
			casecnt = Integer.parseInt(in.nextLine());
		}
		
	}

}
