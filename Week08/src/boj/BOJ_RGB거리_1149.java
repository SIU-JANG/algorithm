package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_RGB거리_1149 {
	
	static int N, ans;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		// < 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// >
		
		// dp 배열을 차례로 돌면서 조건에 맞게 갱신한다.
		for (int i = 1; i < N; i++) {
			dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		
		ans = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
		
		System.out.println(ans);
	}
}
