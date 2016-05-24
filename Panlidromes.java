package hello;

import java.util.HashMap;
import java.util.Scanner;

public class Panlidromes {
	
	public static void main(String[] arg){
		Scanner in = new Scanner(System.in);
		HashMap<Character, Character> map = init();
		while(in.hasNextLine()){
			String input = in.nextLine();
			if(input.compareTo("") == 0){
				break;
			}
			char[] inputArr = input.toCharArray();

			char[] revArr = new char[inputArr.length];
			char[] panArr = new char[inputArr.length];

			boolean isMirrored = true;
			for(int i = 0; i < inputArr.length;i++){
				if(!map.containsKey(inputArr[i])){
					isMirrored = false;
					break;
				}
			}
			for(int i =0; i < revArr.length;i++){
				char tempA = inputArr[i];
				if(map.containsKey(tempA)){
					tempA = (char)map.get(tempA);
				}
				panArr[i] = tempA;
				
				char tempB = inputArr[revArr.length-i-1];
				
				if(map.containsKey(tempB)){
					tempB = (char)map.get(tempB);
				}
				
				revArr[i] = tempB;
			}
			
			
			
			StringBuilder revBuilder = new StringBuilder(input);
			String revStr = revBuilder.reverse().toString();
			
			String panStr = "";
			for(int j = 0; j < panArr.length;j++){
				panStr+=panArr[j];
			}
			StringBuilder panStrRev = new StringBuilder(panStr);
			panStrRev = panStrRev.reverse();

			if(input.compareTo(panStr) == 0 && input.compareTo(panStrRev.toString()) == 0 && input.compareTo(revStr) == 0 && isMirrored){
				System.out.println(input + " -- is a mirrored palindrome.");
			}else if(input.compareTo(panStrRev.toString()) == 0 && isMirrored){
				System.out.println(input + " -- is a mirrored string.");
			}else if(input.compareTo(revStr) == 0){
				System.out.println(input + " -- is a regular palindrome.");
			}else{
				System.out.println(input + " -- is not a palindrome.");
			}
			System.out.println();
		}
			
		
	}
	
	public static HashMap<Character, Character> init(){
		HashMap<Character, Character> temp = new HashMap<Character, Character>();
		temp.put('A', 'A');
		temp.put('E', '3');
		temp.put('H', 'H');
		temp.put('I', 'I');
		temp.put('J', 'L');
		temp.put('L', 'J');
		temp.put('M', 'M');
		temp.put('O', 'O');
		temp.put('S', '2');
		temp.put('T', 'T');
		temp.put('U', 'U');
		temp.put('V', 'V');
		temp.put('W', 'W');
		temp.put('X', 'X');
		temp.put('Y', 'Y');
		temp.put('Z', '5');
		temp.put('1', '1');
		temp.put('2', 'S');
		temp.put('3', 'E');
		temp.put('5', 'Z');
		temp.put('8', '8');
		return temp;
	}

}
