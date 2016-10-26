package acm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//Uva 10191 - Longest Nap 【Wrong Answer】

public class LongestNap {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String info;
		int cnt;
		int start = 10*60, end = 18*60;
		int day = 0;
		while(in.hasNextLine()){
			 info = in.nextLine();
			 if(info.compareTo("") == 0){
				 break;
			 }
			cnt = Integer.parseInt(info);

			
			ArrayList<Integer> startTimeList  = new ArrayList<Integer>();
			HashMap<Integer, Integer> timePair = new HashMap<Integer, Integer>();
			int lastlastTime = 10*60;
			for(int i = 0; i <cnt; i++){
				String line = in.nextLine();
				String tokens[] = line.split(" ");

				String firstTime[] = tokens[0].split(":");
				String secondTime[] = tokens[1].split(":");
				int firstHr = Integer.parseInt(firstTime[0]);
				int firstMin = Integer.parseInt(firstTime[1]);

				int secHr = Integer.parseInt(secondTime[0]);
				int secMin = Integer.parseInt(secondTime[1]);
				int startTime = firstHr*60+firstMin;
				int endTime = secHr*60 + secMin;

				timePair.put(startTime, endTime);
				startTimeList.add(startTime);
				if(endTime > lastlastTime) lastlastTime = endTime;
				
				
			}

			startTimeList.sort(null);

			int firstNapTime = startTimeList.get(0) - start;
			int lastNapTime = end - lastlastTime;
			
			int longest = (firstNapTime > lastNapTime ? firstNapTime : lastNapTime);
			int from = (firstNapTime >= lastNapTime ? start : lastlastTime);
			int currentEnd = 10*60;

			for(int i = 0; i < startTimeList.size() - 1; i++){
				int fs = startTimeList.get(i);
				int fe = timePair.get(fs);
				int ss = startTimeList.get(i+1);
				int se = timePair.get(ss);

				if(fe < ss && se > currentEnd){
					int diff = 0;
					boolean k = false;
					if(fe > currentEnd){
						diff = ss - fe;
						k = true;
						
					}else{
						diff = ss - currentEnd;
					}
					
					if(diff > longest) {
						
						longest = diff;

						from = k?fe:currentEnd;
					}
					
				}
				if(fe > currentEnd) currentEnd = fe;

			}
			
			int hr = longest / 60;
			int min = longest % 60;
			
			System.out.println();
			if(hr == 0){
				System.out.printf("Day #%d: the longest nap starts at %d:%02d and will last for %d minutes.",++day,from/60,from%60,min);
			}else{
				System.out.printf("Day #%d: the longest nap starts at %d:%0"
						+ "2d and will last for %d hours and %d minutes.",++day,from/60,from%60,hr,min);
			}
		}
	}

}
