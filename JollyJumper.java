package hello;

import java.util.Scanner;

public class JollyJumper {
	
	public static void main(String[] args){
		int[] std = new int[3000];
		for(int i = 0; i < std.length;i++){
			std[i] = i+1;
		}
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()){
			String input = in.nextLine();
			if(input.equals("")){
				break;
			}
			String[] numStr = input.split(" ");
			String output = "Jolly";
			if(numStr.length > 2){
				int[] num = new int[numStr.length];
				int[] check = new int[numStr.length-2];
				for(int i = 0; i <numStr.length; i++){
					num[i] = Integer.parseInt(numStr[i]);
				}
							
				for(int j = 1;j<num[0];j++){
					check[j-1] = Math.abs(num[j]-num[j+1]);
				}
				
				sort(check);

				for(int i = 0; i < check.length;i++){
					if(check[i] == std[i]){
						continue;
					}else{
						output = "Not jolly";
						break;
					}
				}
			}else{
				output = "Jolly";
			}

			System.out.println(output);
		}
	}
	
	
	//heap sort
	public static void sort(int[] pq) {
        int N = pq.length;
        for (int k = N/2; k >= 1; k--)
            sink(pq, k, N);
        while (N > 1) {
            exch(pq, 1, N--);
            sink(pq, 1, N);
        }
    }

   /***************************************************************************
    * Helper functions to restore the heap invariant.
    ***************************************************************************/

    private static void sink(int[] pq, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

   /***************************************************************************
    * Helper functions for comparisons and swaps.
    * Indices are "off-by-one" to support 1-based indexing.
    ***************************************************************************/
    private static boolean less(int[] pq, int i, int j) {
        return pq[i-1]- pq[j-1] < 0;
    }

    private static void exch(int[] pq, int i, int j) {
        int swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    // is v < w ?
    private static boolean less(int v, int w) {
        return v-w < 0;
    }
	

}
