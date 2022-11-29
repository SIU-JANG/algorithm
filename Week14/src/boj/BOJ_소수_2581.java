package boj;

import java.util.Scanner;

public class BOJ_소수_2581 {
	
	static int M, N, ans, min;
	static int[] primes = new int[10001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		findPrimes();
		
		for (int i = M; i <= N; i++) {
			if (primes[i] > 0) {
				ans += i;
				
				if (min == 0) min = i;
			}
		}
		
		if (min == 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(ans);
		System.out.println(min);
	}
	
	static void findPrimes() {
		for (int i = 2; i <= 10000; i++) {
			primes[i] = i;
		}
		
		for (int i = 2; i <= 100; i++) {
			if (primes[i] == 0) continue;
			
			for (int j = i * 2; j <= 10000; j += i) {
				primes[j] = 0;
			}
		}
	}
}
