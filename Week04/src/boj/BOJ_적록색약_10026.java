package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Color {
	int x;
	int y;
	char color;
	
	public Color(int x, int y, char color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
}

public class BOJ_적록색약_10026 {
	
	static int N, ans;
	static char[][] map;
	static boolean[][] checked;
	static Queue<Color> q;
	
	// delta
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		checked = new boolean[N][N];
		q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!checked[i][j]) {
					checked[i][j] = true;
					q.add(new Color(i, j, map[i][j]));
					bfs();
					ans++;
				}
			}
		}
		
		System.out.print(ans + " ");
		
		ans = 0;
		checked = new boolean[N][N];
		q.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R') map[i][j] = 'G';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!checked[i][j]) {
					checked[i][j] = true;
					q.add(new Color(i, j, map[i][j]));
					bfs();
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			Color cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !checked[nx][ny] && map[nx][ny] == cur.color) {
					checked[nx][ny] = true;
					q.add(new Color(nx, ny, cur.color));
				}
			}
		}
	}
}
