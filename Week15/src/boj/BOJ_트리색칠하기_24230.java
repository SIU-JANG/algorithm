package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_트리색칠하기_24230 {
	
	static int N, ans;
	
	static List<Integer>[] nodes;
	static int[] colors;
	static boolean[] checked;
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		nodes = new ArrayList[N + 1];
		colors = new int[N + 1];
		checked = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			colors[i] = Integer.parseInt(st.nextToken());
		}
				
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			nodes[x].add(y);
			nodes[y].add(x);
		}
		
		checked[1] = true;
		if (colors[1] != 0) ans++;
		
		dfs(1);
		
		System.out.println(ans);
	}
	
	static void dfs(int parent) {
		for (int child : nodes[parent]) {
			if (!checked[child]) {
				checked[child] = true;
				
				if (colors[parent] != colors[child]) ans++;
				
				dfs(child);
			}
		}
	}
}
