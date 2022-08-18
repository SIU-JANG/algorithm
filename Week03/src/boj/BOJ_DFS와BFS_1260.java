package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_DFS와BFS_1260 {
	
	static int N, M, V;
	static int[][] graph = new int[1001][1001];
	static boolean[] checked;
	static Queue<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		checked = new boolean[1001];
		
		// DFS
		dfs(V);
		System.out.println();
		
		checked = new boolean[1001];
		
		// BFS		
		bfs();
	}
	
	static void dfs(int start) {
		checked[start] = true;
		System.out.print(start + " ");
		
		for (int i = 0; i < 1001; i++) {
			if (graph[start][i] == 1 && !checked[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs() {
		q.add(V);
		checked[V] = true;
		
		while (!q.isEmpty()) {
			int currentSize = q.size();
			for (int i = 0; i < currentSize; i++) {
				int current = q.poll();
				System.out.print(current + " ");
				for (int j = 0; j < 1001; j++) {
					if (graph[current][j] == 1 && !checked[j]) {
						q.add(j);
						checked[j] = true;
					}
				}
			}
		}
	}
}
