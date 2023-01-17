package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_성곽_2234 {
	
	static int N, M;
	static int[][] map;
	
	static int cnt, maxSize = Integer.MIN_VALUE;
		
	// bfs
	static boolean[][] checked;
	
	// delta
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 방의 개수 + 가장 넓은 방의 넓이 계산
		checked = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!checked[i][j]) {
					checked[i][j] = true;
					maxSize = Math.max(maxSize, bfs(i, j));
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(maxSize);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int bit = 1; bit < 16; bit <<= 1) {
					if ((map[i][j] & bit) != 0) {
						checked = new boolean[N][M];
						map[i][j] -= bit;
						checked[i][j] = true;
						maxSize = Math.max(maxSize, bfs(i, j));
						map[i][j] += bit;
					}
				}
			}
		}
		
		System.out.println(maxSize);
	}
	
	static int bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(x, y));
		int size = 1;
		
		while (!q.isEmpty()) {
			Node n = q.poll();
			
			int v = map[n.x][n.y];
			
			int bit = 1;
			
			for (int d = 0; d < 4; d++) {
				if ((v & bit) == 0) {
					int nx = n.x + dx[d];
					int ny = n.y + dy[d];
					
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !checked[nx][ny]) {
						checked[nx][ny] = true;
						q.add(new Node(nx, ny));
						size++;
					}
				}
				
				bit <<= 1;
			}
		}
		
		return size;
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
