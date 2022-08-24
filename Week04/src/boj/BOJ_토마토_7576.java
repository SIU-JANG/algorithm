package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int x;
	int y;
	
	public Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_토마토_7576 {
	
	static int N, M, ans;
	static int[][] map;
	static Queue<Tomato> q;
	
	// delta
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q.add(new Tomato(i, j));
				}
			}
		}
		
		bfs();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(ans - 1);
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			int currentSize = q.size();
			for (int i = 0; i < currentSize; i++) {
				Tomato cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
						map[nx][ny] = 1;
						q.add(new Tomato(nx, ny));
					}
				}
			}
			ans++;
		}
	}
}
