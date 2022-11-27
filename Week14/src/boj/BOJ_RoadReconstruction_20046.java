package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_RoadReconstruction_20046 {
	
	static int N, M;
	static int[][] map;
	
	// dijkstra
	static int[][] cost;
	static boolean[][] checked;
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
	
	// delta
	static int[] du = { 1, -1, 0, 0 };
	static int[] dv = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws Exception {
		
		// -- Input --
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cost = new int[N][M];
		checked = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// -- End Input --
		
		// -- Initializing cost --
		for (int i = 0; i < N; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		
		// -- Edge case handling ( map[0][0] == -1 ) --
		if (map[0][0] == -1) {
			System.out.println(-1);
			return;
		}
				
		
		// -- Dijkstra --
		int answer = dijkstra();
		
		// -- Print answer --
		System.out.println(answer);
	}
	
	static int dijkstra() {
		int ret = 0;
		
		cost[0][0] = map[0][0];
		pq.add(new Edge(0, 0, cost[0][0]));
		
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if (checked[e.u][e.v] || e.c > cost[e.u][e.v]) continue;
			
			checked[e.u][e.v] = true;
			
			for (int d = 0; d < 4; d++) {
				int nu = e.u + du[d];
				int nv = e.v + dv[d];
				
				if (nu >= 0 && nu < N && nv >= 0 && nv < M && !checked[nu][nv] && map[nu][nv] != -1) {
					if (map[nu][nv] == 0) cost[nu][nv] = cost[e.u][e.v];
					else if (map[nu][nv] == 1) cost[nu][nv] = Math.min(cost[nu][nv], cost[e.u][e.v]+ 1 );
					else if (map[nu][nv] == 2) cost[nu][nv] = Math.min(cost[nu][nv], cost[e.u][e.v] + 2);
					
					pq.add(new Edge(nu, nv, cost[nu][nv]));
				}
			}
		}
		
		if (cost[N - 1][M - 1] == Integer.MAX_VALUE) ret = -1;
		else ret = cost[N - 1][M - 1];
		
		return ret;
	}
	
	static class Edge {
		int u;
		int v;
		int c;
		
		public Edge(int u, int v, int c) {
			this.u = u;
			this.v = v;
			this.c = c;
		}
	}
}
