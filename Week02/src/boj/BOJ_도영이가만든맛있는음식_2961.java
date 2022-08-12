package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_도영이가만든맛있는음식_2961 {
	
	static int N, min;
	static int[][] src;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		src = new int[N][2];
		
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(min);
	}
	
	static void dfs(int srcIdx, int sinSum, int ssnSum) {
		if (srcIdx == N) {
			return;
		}
		
		int currSin = src[srcIdx][0] * sinSum;
		int currSsn = src[srcIdx][1] + ssnSum;
		
		min = Math.min(min, Math.abs(currSin - currSsn));
		
		dfs(srcIdx + 1, currSin, currSsn);	// 현재 재료 선택 O
		dfs(srcIdx + 1, sinSum, ssnSum);	// 현재 재료 선택 X
	}
}
