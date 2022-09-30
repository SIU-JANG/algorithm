package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_등산_1486 {
	
	static int N, M, T, D;
	static int[][] map;
	
	static int[][] cost;
	static boolean[][] checked;
	
	// delta
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> (e1.c - e2.c));
	
	public static void main(String[] args) throws Exception {
		// < 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		cost = new int[N][M];
		checked = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String tempStr = br.readLine();
		}
		// >
	}
	
	// dijkstra
	static void dijkstra(int i, int j) {
		reset();
		
		cost[i][j] = 0;
		pq.add(new Edge(i, j, 0));
		
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if (e.c > cost[e.x][e.y] || checked[e.x][e.y]) continue;
			
			for (int d = 0; d < 4; d++) {
				// 가려는 곳의 높이가 현재 있는 곳과 같거나 작으면
				if (map[e.x + dx[d]][e.y + dy[d]] <= map[e.x][e.y]) {
					if (!checked[e.x + dx[d]][e.y + dy[d]] && cost[e.x][e.y] + 1 < cost[e.x + dx[d]][e.y + dy[d]]) {
						cost[e.x + dx[d]][e.y + dy[d]] = cost[e.x][e.y] + 1;
						pq.add(new Edge(e.x + dx[d], e.y + dy[d], cost[e.x + dx[d]][e.y + dy[d]]));
					}
				} else {
					// 가려는 곳의 높이가 현재 있는 곳보다 크면
					if (Math.pow(map[e.x + dx[d]][e.y + dy[d]] - map[e.x][e.y] , 2) <= T) {
						
					}
					if (!checked[e.x + dx[d]][e.y + dy[d]] && cost[e.x][e.y] + (int)Math.pow(map[e.x + dx[d]][e.y + dy[d]], 2) < cost[e.x + dx[d]][e.y + dy[d]]) {
						cost[e.x + dx[d]][e.y + dy[d]] = cost[e.x][e.y] + (int)Math.pow(map[e.x + dx[d]][e.y + dy[d]], 2);
						pq.add(new Edge(e.x + dx[d], e.y + dy[d], cost[e.x + dx[d]][e.y + dy[d]]));
					}
				}
			}
		}
		
		
	}
	
	static void reset() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
			Arrays.fill(checked[i], false);
		}
	}
	
	static class Edge {
		int x;
		int y;
		int c;
		
		public Edge(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
