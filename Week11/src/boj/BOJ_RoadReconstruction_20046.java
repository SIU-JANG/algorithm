package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_RoadReconstruction_20046 {
	
	static int n, m;
	static int[][] map;
	
	static int[][] dist;
	static boolean[][] checked;
	
	static PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> (map[n1.x][n1.y] - map[n2.x][n2.y]));
	
	// delta
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dist = new int[n][m];
		checked = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		dist[0][0] = map[0][0];
		
		if (map[0][0] == -1 || map[n - 1][m - 1] == -1) {
			System.out.println(-1);
			return;
		}
		
		pq.add(new Node(0, 0));
		
		bfs();
		
		if (dist[n - 1][m - 1] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dist[n - 1][m - 1]);			
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dist[i][j] == Integer.MAX_VALUE) {
					System.out.print(-1 + " ");					
				} else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	
	static void bfs() {
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != -1 && dist[nx][ny] > dist[node.x][node.y]) {
					dist[nx][ny] = dist[node.x][node.y] + map[nx][ny];
					pq.add(new Node(nx, ny));
				}
			}
		}
	}
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
