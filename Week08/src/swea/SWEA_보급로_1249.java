package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SWEA_보급로_1249 {
	
	static int T, N;
	static int[][] map;
	
	// bfs
	static Queue<Node> q = new ArrayDeque<>();
	static int[][] dist;
	
	// delta
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			dist[0][0] = map[0][0];
			q.add(new Node(0, 0));
			
			bfs();
			
			System.out.println("#" + test_case + " " + dist[N - 1][N - 1]);
		}
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			Node n = q.poll();
			
			int x = n.x;
			int y = n.y;
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && dist[nx][ny] > dist[x][y] + map[nx][ny]) {
					dist[nx][ny] = dist[x][y] + map[nx][ny];
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
