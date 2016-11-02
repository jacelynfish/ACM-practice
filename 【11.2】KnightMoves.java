package acm;

import java.util.ArrayDeque;
import java.util.Scanner;

//Uva 439 - Knight Moves ¡¾Runtime error¡¿

public class KnightMoves {

	public static boolean marked[][];
	public static int dir[][] = {{1,-2},{1,2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
	public static Square start, end;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String info = in.nextLine();

		while(info.compareTo("") != 0){
			String temp[] = info.split(" ");
			start = new Square(temp[0]);
			end = new Square(temp[1]);
			
			marked = new boolean[8][8];
			for(int i = 0; i < 8; i++ ){
				for(int j = 0; j < 8; j++){
					marked[i][j] = false;
				}
			}
			
			if(!(start.x == end.x && start.y == end.y)){
				bfs();
			}
			System.out.println("To get from "+ temp[0] +" to "+temp[1]+" takes "+end.curStep+" knight moves.");
			info = in.nextLine();
		}
	}
	
	public static void bfs(){
		ArrayDeque<Square> queue = new ArrayDeque<Square>();
		queue.add(start);
		marked[start.x][start.y] = true;
		while(!queue.isEmpty()){
			Square curPos = queue.poll();
			for(int i = 0; i < 8; i++){
				int dx = curPos.x + dir[i][0];
				int dy = curPos.y + dir[i][1];
			
				if(dx >= 0 && dx < 8 && dy >= 0 && dy < 8){

					if(dx == end.x && dy == end.y){
						end.curStep = curPos.curStep + 1;
						return;
					}
					if(!marked[dx][dy]){
						marked[dx][dy] = true;
						Square temp = new Square(dx, dy, curPos.curStep + 1);
						queue.add(temp);
						
					}
				}
				
			
			}
			
			
		}
	}

}
class Square{
	public int x, y, curStep;
	public Square(String temp){
		char arr[] = temp.toCharArray();
		this.x = (int)(arr[1] - '0') - 1;
		this.y = (int)(arr[0] - 'a');
		this.curStep = 0;
	}
	public Square(int x, int y, int step){
		this.x = x;
		this.y = y;
		this.curStep = step;
	}
}
