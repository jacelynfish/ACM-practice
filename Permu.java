package hello;

import java.util.ArrayList;
import java.util.Scanner;

public class Permu {
	
	public static void main(String[] arg){
		Scanner in = new Scanner(System.in);
		
		String first;
		String second;
		while(in.hasNextLine()){
			first = in.nextLine();
			second = in.nextLine();
//			if(first.compareTo("") == 0 || second.compareTo("") == 0){
//				break;
//			}
			ArrayList<Character> letters = new ArrayList<Character>();
			ArrayList<Character> alreadyUsed = new ArrayList<Character>();
			String temp = (first.length() <second.length())? first: second;
			String other = (first.length() <second.length())? second:first;
			char[] tempArr = temp.toCharArray();
			char[] otherArr = other.toCharArray();
			
			ArrayList<Character> tempList = new ArrayList<Character>();
			ArrayList<Character> otherList = new ArrayList<Character>();
			
			for(char ta : tempArr){
				tempList.add(ta);
			}
			for(char oa : otherArr){
				otherList.add(oa);
			}
			tempList.sort(null);
			otherList.sort(null);
			int c = 0;
			for(char tl:tempList){
				tempArr[c] = tl;
				c++;
			}
			c = 0;
			for(char ol :otherList){
				otherArr[c] = ol;
				c++;
			}

			for(int j = 0,i= 0;i < other.length() &&  j < temp.length();){
				if(tempArr[j] == otherArr[i]){
					letters.add(otherArr[i]);
					j++;
					i++;
				}else if(tempArr[j] > otherArr[i]){
					i++;
				}else{
					j++;
				}
				
				
			}
			
			int count = 0;
			char[] letterArr = new char[letters.size()];
			for(char l : letters){
				letterArr[count] = l;
				count++;
			}
			System.out.println(letterArr);
			
		}
	}

}
