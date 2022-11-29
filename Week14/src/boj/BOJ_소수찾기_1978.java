package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_소수찾기_1978 {
	
	static int N, ans;
	
	static int[] primes = new int[1001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		findPrimes();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if (primes[n] > 0) ans++;
		}
		
		System.out.println(ans);
	}
	
	static void findPrimes() {
		for (int i = 0; i <= 1000; i++) {
			primes[i] = i;
		}
		
		primes[1] = 0;
		
		for (int i = 2; i <= Math.sqrt(1000); i++) {
			if (primes[i] == 0) continue;
			
			for (int j = i * 2; j <= 1000; j += i) {
				primes[j] = 0;
			}
		}
	}
}
