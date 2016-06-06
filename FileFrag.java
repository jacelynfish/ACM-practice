package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FileFrag {
	public static void main(String[] arg){
		Scanner in = new Scanner(System.in);
		String caseInfo = in.nextLine();
		int caseCnt = Integer.parseInt(caseInfo);
		String empty = in.nextLine();
		for(int i = 0; i < caseCnt; i++){
			ArrayList<String> frags = new ArrayList<String>();
			while(in.hasNextLine()){
				String frag = in.nextLine();
				if(frag.compareTo("") == 0){
					break;
				}
				
					frags.add(frag);
			}			

			HashMap<Integer, ArrayList<String>> fragMap = new HashMap<Integer, ArrayList<String>>();
			int minLen = 1000, maxLen = -1, totalLen = 0;
			for(String f : frags){
				int fragLen = f.length();
				if(fragLen < minLen){
					minLen = fragLen;
				}
				if(fragLen > maxLen){
					maxLen = fragLen;
				}
				ArrayList<String> divFrag;
				if(!fragMap.containsKey(fragLen)){
					divFrag = new ArrayList<String>();
				}else{
					divFrag = fragMap.get(fragLen);
				}
				divFrag.add(f);
				fragMap.put(fragLen, divFrag);
			}
			if(fragMap.size() == 1){
				ArrayList<String> two = fragMap.get(minLen);
				if(two.size() == 2 && two.get(0).length() == 1 && two.get(1).length() == 1){
					Object[] twoTemp = two.toArray();
					for(int k = two.size() - 1; k >=0; k--){
						System.out.print(twoTemp[k]);
					}
					System.out.println();
					System.out.println();
					continue;
				}
				
			}
			
			totalLen = minLen + maxLen;
			String resultStr = "";
			for(Map.Entry<Integer, ArrayList<String>> entry : fragMap.entrySet()){
				int len = entry.getKey();
				ArrayList<String> fragFirst = entry.getValue();
				ArrayList<String> fragSecond = fragMap.get(totalLen - len);
				
				String rTemp = "";
				String resultTemp = "";
				boolean thisMatch = false;
				for(String currentF : fragFirst){
					
					for(String currentS : fragSecond){
						boolean groupMatch = false;
						String temp = currentF + currentS;
						String revTemp = currentS + currentF;
						
							rTemp = temp;

						for(Map.Entry<Integer, ArrayList<String>> e : fragMap.entrySet()){
							int l = e.getKey();
							ArrayList<String> fragF = e.getValue();
							ArrayList<String> fragS = fragMap.get(totalLen - l);
							if(minLen!=maxLen && (l == len || totalLen - l == len)){
								continue;
							}
							boolean plusMatch = false;
							for(String fi : fragF){
								for(String fs : fragS){
									String plus = fi + fs;
									if(plus.compareTo(temp) == 0 || plus.compareTo(revTemp) == 0){
										resultTemp = (plus.compareTo(temp) == 0)? temp:revTemp;
										plusMatch = true;
										break;
									}
								}
								if(plusMatch){
									groupMatch = true;
									break;
									
								}else{
									groupMatch = false;
								}
									
							}
						}
						if(groupMatch){
							thisMatch = true;
							break;
						}else{
							thisMatch = false;
						}
					}
					
				}
				if(thisMatch){
						System.out.println(resultTemp);
					}else{
						System.out.println(rTemp);
					}
				break;	
			}
			System.out.println();
		}
	}
}


