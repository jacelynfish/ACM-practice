package hello;

import java.util.ArrayList;
import java.util.Scanner;

public class Smith {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String casei = in.nextLine();
		int caseCnt = Integer.parseInt(casei);
		for(int i = 0; i < caseCnt; i++){
			
			String noi = in.nextLine();
			int nof = Integer.parseInt(noi);
			for(int no = nof + 1; ;no++){
				if(isPrime(no)){
					continue;
				}else{

					ArrayList<Integer> primes = new ArrayList<Integer>();
					
					getPrimeFactors(no,primes);
					int primeTotal = 0;
					for(Integer p : primes){

						if(p > 9){
							int pk = p;
							while(pk != 0){
						

								primeTotal += pk % 10;
								pk = pk / 10;
								
								
							}
						}else{

							primeTotal += p;
						}
					}
					int noTotal = 0;
					int nok = no;
					for(int k = 0; k <= noi.length();k++){
						noTotal += nok%10;
						nok = nok / 10;
						
					}
					
					if(primeTotal == noTotal){
						System.out.println(no);
						break;
					}else{
						continue;
					}
				}
				
			}

		}
	}
	
	public static void getPrimeFactors(int no, ArrayList<Integer> primes){
		int[] factors = getFactors(no);
		if(isPrime(no)){
			primes.add(no);
		}else{

			int first = factors[2];
			int second = factors[3];
			if(isPrime(first)){
				primes.add(first);
			}else{
				getPrimeFactors(first,primes);
			}
			
			if(isPrime(second)){
				primes.add(second);
			}else{
				getPrimeFactors(second,primes);
			}
		}
	}
	
	public static boolean isPrime(int no){
		int[] factors = getFactors(no);
		if(factors.length == 2){
			return true;
		}else{
			return false;
		}
	}
	
	public static int[] getFactors(int no){
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int sqrt = (int) Math.floor(Math.sqrt(no));
		for(int i = 1; i <= sqrt; i++){
			if(no % i == 0){
				factors.add(i);
				factors.add(no / i);
			}
		}
		int count = 0;
		int[] fac = new int[factors.size()];
		for(Integer f : factors){
			fac[count] = f;
			count++;
		}
		return fac;
		
	}

}
