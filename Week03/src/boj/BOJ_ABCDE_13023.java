package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_ABCDE_13023 {
	
	static int N, M, ans;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
		
		for (int i = 0; i < N; i++) {
			dfs(i, 1, 1 << i);
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int person, int cnt, int mask) {
		if (ans == 1) return;
		
		if (cnt == 5) {
			ans = 1;
			return;
		}
		
		for (int i = 0; i < graph[person].size(); i++) {
			if ((mask & 1 << graph[person].get(i)) == 0) {
				dfs(graph[person].get(i), cnt + 1, mask | 1 << graph[person].get(i));
			}
		}
	}
}
