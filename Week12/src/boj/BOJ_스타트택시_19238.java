package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_스타트택시_19238 {
	
	static int N, M, oil, sx, sy, cx, cy, desX, desY, tx, ty, dist, ans;
	static int[][] map;
	static Node[][] customerLoc;
	
	// bfs
	static boolean[][] checked;
	static Queue<Node> q = new ArrayDeque<>();
	
	// delta
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		oil = Integer.parseInt(st.nextToken());
		
		// 0 : 빈칸, 1 : 벽
		map = new int[N][N];
		checked = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 택시의 시작 위치
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;
		
		customerLoc = new Node[M][2];
		
		// 손님의 위치와 목적지 위치
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			cx = Integer.parseInt(st.nextToken()) - 1;
			cy = Integer.parseInt(st.nextToken()) - 1;
			desX = Integer.parseInt(st.nextToken()) - 1;
			desY = Integer.parseInt(st.nextToken()) - 1;
			
			map[cx][cy] = 2;
			
			customerLoc[i][0] = new Node(cx, cy);
			customerLoc[i][1] = new Node(desX, desY);
		}
		
		int cnt = 0;
		// 손님을 다 태우면 끝난다.
		while (cnt < M) {			
			// 1. (sx, sy)에서 시작해 1에서 찾은 손님이 있는 곳까지 이동한다.(bfs 사용)
			reset();
			
			checked[sx][sy] = true;
			q.add(new Node(sx, sy));
			
			bfs();
			
			// 2. 이동 중 연료가 다 떨어지면 -1을 출력한다.(bfs에서 해결)
			if (ans == -1) {
				System.out.println(ans);
				break;
			}
			
			// 3. 연료가 다 안떨여졌으면 손님의 위치에서 목적지로 이동한다.
			reset();
			dist = 0;
			
			for (int i = 0; i < M; i++) {
				if (customerLoc[i][0].x == sx && customerLoc[i][0].y == sy) {
					tx = customerLoc[i][1].x;
					ty = customerLoc[i][1].y;
				}
			}
			
			checked[sx][sy] = true;
			q.add(new Node(sx, sy));
			
			bfs_2();
			
			// 4. 이동 주 연료가 다 떨어지면 -1을 출력한다.
			if (ans == -1) {
				System.out.println(ans);
				break;
			}
			
			// 5. 손님의 목적지에 도착하면 손님이 있던 장소와 목적지 사이의 거리 * 2 만큼의 연료를 다시 충전한다.
			oil += dist * 2;
		}
		
		if (ans != -1) {
			System.out.println(oil);			
		}
	}
	
	static void reset() {
		q.clear();
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(checked[i], false);
		}
	}
	
	static void bfs() {
		while (!q.isEmpty()) {
			Node next = q.poll();
			
			int x = next.x;
			int y = next.y;
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !checked[nx][ny] && map[nx][ny] == 0) {					
					checked[nx][ny] = true;
					q.add(new Node(nx, ny));
				} else if (nx >= 0 && nx < N && ny >= 0 && ny < N && !checked[nx][ny] && map[nx][ny] == 2) {			
					oil--;
					
					// 택시의 위치 변경
					sx = nx;
					sy = ny;
					
					map[nx][ny] = 0;
					
					return;
				}
			}
			
			oil--;
			if (oil <= 0) {
				ans = -1;
				return;
			}
		}
	}
	
	static void bfs_2() {
		while (!q.isEmpty()) {
			Node next = q.poll();
			
			int x = next.x;
			int y = next.y;
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !checked[nx][ny] && map[nx][ny] == 0) {					
					checked[nx][ny] = true;
					q.add(new Node(nx, ny));
				} else if (nx >= 0 && nx < N && ny >= 0 && ny < N && !checked[nx][ny] && nx == tx && ny == ty) {			
					dist++;
					oil--;
					
					// 택시의 위치 변경
					sx = nx;
					sy = ny;
					
					map[nx][ny] = 0;
					
					return;
				}
			}
			
			oil--;
			if (oil <= 0) {
				ans = -1;
				return;
			}
			dist++;
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
