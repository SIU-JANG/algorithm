package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_트리의부모찾기_11725 {
	
	static int N;
	static List<Integer>[] nodes;
	static int[] ans;
	static boolean[] checked;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nodes = new ArrayList[N + 1];
		ans = new int[N + 1];
		checked = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		StringTokenizer st = null;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			nodes[x].add(y);
			nodes[y].add(x);
		}
		
		checked[1] = true;
		dfs(1);
		
		for (int i = 2; i <= N; i++) {
			System.out.println(ans[i]);
		}
	}
	
	static void dfs(int parent) {
		for (int child : nodes[parent]) {
			if (!checked[child]) {
				checked[child] = true;
				ans[child] = parent;
				dfs(child);
			}
		}
	}
}
