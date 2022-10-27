package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_RoadReconstruction_20046 {
	
	static int n, m;
	static int[][] map;
	
	static int[][] dist;
	
	static Queue<Node> q = new ArrayDeque<>();
	
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
		
		if (map[0][0] == -1) {
			System.out.println(-1);
			return;
		}
		
		q.add(new Node(0, 0));
		
		bfs();
		
		if (dist[n - 1][m - 1] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dist[n - 1][m - 1]);			
		}
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			Node node = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != -1 && dist[nx][ny] > dist[node.x][node.y]) {
					if (map[nx][ny] == 0) {
						dist[nx][ny] = dist[node.x][node.y];
					} else if (map[nx][ny] == 1) {
						dist[nx][ny] = dist[node.x][node.y] + 1; 
					} else if (map[nx][ny] == 2) {
						dist[nx][ny] = dist[node.x][node.y] + 2; 
					}
					
					q.add(new Node(nx, ny));
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
