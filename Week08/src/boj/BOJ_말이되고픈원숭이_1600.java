package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_말이되고픈원숭이_1600 {
	
	static int K, ans = Integer.MAX_VALUE;
	static int W, H;
	static int[][] map;
	
	// bfs variables
	static boolean[][][] checked;
	static Queue<Node> q = new ArrayDeque<>();
	// delta
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	// horse move delta
	static int[] hdx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] hdy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	
	public static void main(String[] args) throws Exception {
		// < 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		checked = new boolean[H][W][K + 1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// >
		
		// bfs를 사용해 모든 경우를 탐색하고 가능한 최솟값을 구한다.
		// checked[][][0] => 말처럼 이동을 안했을 때 방문 여부 체크
		// checked[][][1] => 말처럼 이동을 1번했을 때 방문 여부 체크
		checked[0][0][K] = true;
		q.add(new Node(0, 0, 0, K));
		bfs();
		
		if (ans == Integer.MAX_VALUE) ans = -1; 
		System.out.println(ans);
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			int dist = n.dist;
			int h = n.h;
			
			// Complete Code(끝 지점에 도착한 경우)
			if (x == H - 1 && y == W - 1) {
				ans = Math.min(ans, dist);
			}
			
			// 말처럼 이동 X
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx >= 0 && nx < H && ny >= 0 && ny < W && !checked[nx][ny][K - n.h] && map[nx][ny] != 1) {
					checked[nx][ny][K - n.h] = true;
					q.add(new Node(nx, ny, dist + 1, h));
				}
			}
			
			// 말처럼 이동 O
			if (n.h > 0) {
				for (int d = 0; d < 8; d++) {
					int nx = x + hdx[d];
					int ny = y + hdy[d];
					
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && !checked[nx][ny][K - n.h + 1] && map[nx][ny] != 1) {
						checked[nx][ny][K - n.h + 1] = true;
						q.add(new Node(nx, ny, dist + 1, h - 1));
					}
				}
			}			
		}
	}
	
	static class Node {
		int x;
		int y;
		// 도착까지 이동 횟수
		int dist;
		// 남은 말처럼 이동할 수 있는 횟수
		int h;
		
		public Node (int x, int y, int dist, int h) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.h = h;
		}
	}
}
