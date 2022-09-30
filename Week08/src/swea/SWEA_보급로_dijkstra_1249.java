package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWEA_보급로_dijkstra_1249 {
	
	static int T, N;
	static int[][] map;
	
	// dijkstra
	static int INF = Integer.MAX_VALUE;
	static int[][] cost;
	static boolean[][] checked;
	static PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
	
	// delta
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			cost = new int[N][N];
			checked = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			// cost 초기화
			for (int i = 0; i < N; i++) {
				Arrays.fill(cost[i], INF);
			}
			
			dijkstra();
			
			System.out.println("#" + test_case + " " + cost[N - 1][N - 1]);
		}
		
	}
	
	static void dijkstra() {
		cost[0][0] = 0;
		pq.add(new Node(0, 0, 0));
		
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			
			if (n.c > cost[n.x][n.y] || checked[n.x][n.y]) continue;
			
			checked[n.x][n.y] = true; 
			
			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !checked[nx][ny] && cost[n.x][n.y] + map[nx][ny] < cost[nx][ny]) {
					cost[nx][ny] = cost[n.x][n.y] + map[nx][ny];
					pq.add(new Node(nx, ny, cost[nx][ny]));
				}
			}
		}
	}
	
	static class Node {
		int x;
		int y;
		int c;
		
		public Node (int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
