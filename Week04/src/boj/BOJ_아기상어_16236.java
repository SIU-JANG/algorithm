package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Fish implements Comparable<Fish> {
	int x;
	int y;
	int dist;
	
	public Fish(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	@Override
	public int compareTo(Fish o) {
		if (this.dist == o.dist) {
			if (this.x == o.x) {
				return this.y - o.y;
			} else {
				return this.x - o.x;
			}
		} else {
			return this.dist - o.dist;
		}
	}
	
}

class Shark {
	int x;
	int y;
	
	public Shark(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// 시간초과
public class BOJ_아기상어_16236 {
	
	static int N, ans, minDist;
	static int[][] map;
	
	// 아기상어 초기값
	static int sharkSize = 2;
	// 먹이 섭취 횟수
	static int eatCnt = 0;
	// 먹을 수 있는 먹이를 담아두는 리스트
	static List<Fish> foods = new ArrayList<>();
	// 상어의 현재 위치
	static Shark curShark;
	
	// delta
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	static boolean[][] checked;
		
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					curShark = new Shark(i, j);
				}
			}
		}
		
		while (true) {			
			// 1. bfs()를 통해(막혀있는 경우를 빼기위해) 먹을 수 있는 먹이의 위치를 foods 리스트에 저장
			// 동일한 물고기가 있으면 제일 위, 왼쪽 먹이를 먹음
			checked = new boolean[N][N];
			foods.clear();
			minDist = Integer.MAX_VALUE;
			dfs(curShark.x, curShark.y, 0);
						
			// 리스트가 비었다면 엄마 상어를 부름 => 종료
			if (foods.isEmpty()) break;
			// 2. 각 먹이의 거리로 정렬 -> 정렬 순서 : (1)거리 (2)x좌표 (3)y좌표
			Collections.sort(foods);
			
			// 3. 해당 먹이로 이동 후 섭취 -> 몸 크기 변화가 있는지 없는지 체크
			map[curShark.x][curShark.y] = 0;
			curShark.x = foods.get(0).x;
			curShark.y = foods.get(0).y;
			map[foods.get(0).x][foods.get(0).y] = 9;
			ans += foods.get(0).dist;
			eatCnt++;
			
			if (eatCnt >= sharkSize) {
				sharkSize++;
				eatCnt = 0;
			}
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int x, int y, int dist) {
		if (dist > minDist) return;
		
		if (map[x][y] != 0 && map[x][y] < sharkSize) {
			minDist = Math.min(minDist, dist);
			foods.add(new Fish(x, y, dist));
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] <= sharkSize && !checked[nx][ny]) {
				checked[nx][ny] = true;
				dfs(nx, ny, dist + 1);
				checked[nx][ny] = false;
			}
		}
	}
	
}
