package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_군계일학_15966 {
	
	static int N, len, ans;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[1000001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			dp[x] = Math.max(dp[x], dp[x - 1] + 1);
			ans = Math.max(ans, dp[x]);
		}
		
		System.out.println(ans);
	}
}
