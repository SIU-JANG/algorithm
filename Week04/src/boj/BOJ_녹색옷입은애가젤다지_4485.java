package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_녹색옷입은애가젤다지_4485 {
	
	static int N, K, test_case = 1;
	static int[][] map;
	static int[][] cost;
	static boolean[][] checked;
	static PriorityQueue<Edge> pq;
	
	static final int INF = Integer.MAX_VALUE;
	
	// delta
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			map = new int[N][N];
			checked = new boolean[N][N];
			cost = new int[N][N];
			pq = new PriorityQueue<>((e1, e2) -> (e1.c - e2.c));
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = INF;
				}
			}
			
			dijkstra();
			
			System.out.println("Problem " + test_case++ + ": " + cost[N - 1][N - 1]);
		}
	}
	
	static void dijkstra() {
		cost[0][0] = map[0][0];		
		pq.add(new Edge(0, 0, cost[0][0]));
		
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if (checked[e.y][e.x]) continue;
			checked[e.y][e.x]= true; 
			
			for (int d = 0; d < 4; d++) {
				int nx = e.x + dx[d];
				int ny = e.y + dy[d];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !checked[nx][ny]) {
					if (e.c + map[nx][ny] < cost[nx][ny]) {
						cost[nx][ny] = e.c + map[nx][ny];
						pq.add(new Edge(nx, ny, cost[nx][ny]));
					}
				}
			}
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
