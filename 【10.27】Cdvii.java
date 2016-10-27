package acm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
//Uva 10138

public class Cdvii {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int caseCnt = Integer.parseInt(in.nextLine());
		in.nextLine();
		for(int i = 0; i < caseCnt; i++){
			String tollStr = in.nextLine();
			if(tollStr.compareTo("") == 0){
				break;
			}
			String tolllist[] = tollStr.split(" ");
			int tolls[] = new int[24];
			for(int j = 0; j < 24; j++){
				tolls[j] = Integer.parseInt(tolllist[j]);
			}
			ArrayList<String> carList = new ArrayList<String>();
			HashMap<String, ArrayList<TravelInfo>> enterMap = new HashMap<String, ArrayList<TravelInfo>>();
			HashMap<String, ArrayList<TravelInfo>> exitMap = new HashMap<String, ArrayList<TravelInfo>>();
			
			String info = in.nextLine();
			
			while(info.compareTo("")!= 0){
				TravelInfo curInfo = new TravelInfo(info);
				String enterInfo = info.split(" ")[2];
				if(!carList.contains(curInfo.getCarNum())){
					carList.add(curInfo.getCarNum());
				}
				
				if(enterInfo.compareTo("enter") == 0 || enterInfo.compareTo("Enter") == 0){
					ArrayList<TravelInfo> enterList;
					if(enterMap.containsKey(curInfo.getCarNum())){
						enterList = enterMap.get(curInfo.getCarNum());
					}else{
						enterList = new ArrayList<TravelInfo>();
					}
					enterList.add(curInfo);
					enterMap.put(curInfo.getCarNum(), enterList);
					
				}else{
					ArrayList<TravelInfo> exitList;
					if(exitMap.containsKey(curInfo.getCarNum())){
						exitList = exitMap.get(curInfo.getCarNum());
					}else{
						exitList = new ArrayList<TravelInfo>();
					}
					exitList.add(curInfo);
					exitMap.put(curInfo.getCarNum(), exitList);
				}
				
				info = in.nextLine();
				
			}
			
			Collections.sort(carList, new Strcmp());

			for(int j = 0; j < carList.size(); j++){
				String carNum = carList.get(j);
				
				ArrayList<TravelInfo> enterList = null, exitList = null;
				if(enterMap.containsKey(carNum)){
					enterList = enterMap.get(carNum);
				}
				if(exitMap.containsKey(carNum)){
					exitList = exitMap.get(carNum);
				}
				TravelCompare travelCompare = new TravelCompare();
				if(enterList != null && exitList != null){
					Collections.sort(enterList, travelCompare);
					enterMap.put(carNum, enterList);

					Collections.sort(exitList, travelCompare);
					exitMap.put(carNum, exitList);
					
					
				}else{
					continue;
				}
				
				
			}
			
			
			for(int j = 0; j < carList.size(); j++){
				String carNum = carList.get(j);
				ArrayList<TravelInfo> enterList = null, exitList = null;
				if(enterMap.containsKey(carNum)){
					enterList = enterMap.get(carNum);
				}else{
					continue;
				}
				if(exitMap.containsKey(carNum)){
					exitList = exitMap.get(carNum);
				}else{
					continue;
				}
				double totalFee = 0.0;
				for(int k = 0,t = 0; k < enterList.size() && t < exitList.size(); k++, t++){
					TravelInfo enterInfo = enterList.get(k);
					TravelInfo exitInfo;
					
					while(t < exitList.size()){
						
						exitInfo = exitList.get(t);
						boolean check = false;

						if(exitInfo.getTimestamp() > enterInfo.getTimestamp()){
							
							int cents = tolls[enterInfo.getHr()];
							int diffDis = Math.abs(exitInfo.getDistance() - enterInfo.getDistance());
							double fee = ((double)cents*diffDis/100)+1;
							totalFee+=fee;
							break;
						}
						t++;
					}
					
				}
				if(totalFee <= 0){
					continue;
				}
				System.out.printf("%s $%.2f\n",carNum,totalFee+2);
				
				
			}
			
		}
	}
}

class TravelInfo{
	private String carNum;
	private int month, day, hr, min, distance,timestamp;
	
	public TravelInfo(String info){
		String tokens[] = info.split(" ");
		this.carNum = tokens[0];
		String timeTokens[] = tokens[1].split(":");
		this.month = Integer.parseInt(timeTokens[0]);
		this.day = Integer.parseInt(timeTokens[1]);
		this.hr = Integer.parseInt(timeTokens[2]);
		this.min = Integer.parseInt(timeTokens[3]);
		this.timestamp = this.month * 100000000 + this.day * 10000000 + this.hr*1000000 + this.min;
		this.distance = Integer.parseInt(tokens[3]);
	}

	public String getCarNum() {
		return carNum;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getHr() {
		return hr;
	}

	public int getMin() {
		return min;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public int getDistance() {
		return distance;
	}
}

class TravelCompare implements Comparator<TravelInfo>{

	@Override
	public int compare(TravelInfo info1, TravelInfo info2) {

		int result = 0;
		if(info2.getTimestamp() > info1.getTimestamp()){
			result = -1;
		}else if(info2.getTimestamp() < info1.getTimestamp()){
			result = 1;
		}
		return result;
	}
	
}

class Strcmp implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
	
}