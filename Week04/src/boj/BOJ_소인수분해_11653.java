package boj;

import java.util.Scanner;

public class BOJ_소인수분해_11653 {
	
	static int N;
	static int[] primes;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		primes = new int[N + 1];
		
		for (int i = 2; i <= N; i++) {
			primes[i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			if (primes[i] == 0) continue;
			for (int j = i * 2; j <= N; j = j + i) {
				primes[j] = 0;
			}
		}
		
		int ret = N;
		while (ret > 1) {
			for (int i = 2; i <= N; i++) {
				if (primes[i] == 1 && ret % i == 0) {
					ret /= i;
					System.out.println(i);
					break;
				}
			}
		}
	}
}
