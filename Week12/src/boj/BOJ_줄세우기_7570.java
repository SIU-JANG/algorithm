package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_줄세우기_7570 {
	
	// N : 개수, n : 입력된 숫자
	static int N, n, max;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(st.nextToken());
			dp[n] = dp[n - 1] + 1;
			max = Math.max(max, dp[n]);
		}
		
		System.out.println(N - max);
	}
}
