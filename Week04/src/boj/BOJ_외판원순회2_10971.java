package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_외판원순회2_10971 {
	
	static int N, ans = Integer.MAX_VALUE;
	static int[][] graph;
	
	static int[] src;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		src = new int[N];
		for (int i = 0; i < N; i++) {
			src[i] = i;
		}
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			check();
			
			if (!np()) break;
		}
		
		System.out.println(ans);
	}
	
	static void check() {
		int sum = 0;
		for (int i = 0; i < N - 1; i++) {
			int cost = graph[src[i]][src[i + 1]];
			if (cost == 0) return;
			sum += cost;
		}
		int cost = graph[src[N - 1]][src[0]];
		if (cost == 0) return;
		sum += cost;
		
		ans = Math.min(ans, sum);
	}
	
	static boolean np() {
		int i = N - 1;
		while (i > 0 && src[i - 1] >= src[i]) --i;
		
		if (i == 0) return false;
		
		int j  = N - 1;
		while (src[i - 1] >= src[j]) --j;
		swap(i - 1, j);
		
		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}
		
		return true;
	}
	
	static void swap(int i, int j) {
		int temp = src[i];
		src[i] = src[j];
		src[j] = temp;
	}
}
