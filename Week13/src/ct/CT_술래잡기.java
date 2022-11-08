package ct;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CT_술래잡기 {
	
	// n : 맵의 크기, m : 도망자의 수, h : 나무의 수, k : 턴 수
	static int n, m, h, k;
	
	// delta(상, 우, 하, 좌)
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	// 술래의 위치와 방향 그리고 방향전환을 위한 sCount, sTarget
	static int sx, sy, sDir, sCount, sTarget = 1, cnt;
	static boolean isReverse = false;
	
	// 도망자들의 위치를 저장한 배열
	static Fugitive[] fugitives;
	
	// 나무들의 위치를 저장한 배열
	static Tree[] trees;
	
	// 술래의 좌표를 저장하는 리스트(역순에 사용)
	static List<Node> orders;
	
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		fugitives = new Fugitive[m];
				
		// 도망자들(dir)
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			int dir = -1;
			
			// 좌-우 시작 : 우(1)
			if (d == 1) dir = 1;
			// 상-하 시작 : 하(2)
			else if (d == 2) dir = 2;
			
			Fugitive fugitive = new Fugitive(x, y, dir);
			fugitives[i] = fugitive;
		}
		
		// 술래의 첫 위치 설정
		sx = n / 2;
		sy = n / 2;
		// 방향(상 : 0)
		sDir = 0;
		
		trees = new Tree[h];
		
		// 나무들
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			Tree tree = new Tree(x, y);
			trees[i] = tree;
		}
		
		orders = new int[n * n];
		
		// 턴이 끝날 때 까지 반복한다.
		for (int t = 1; t <= k; t++) {

			System.out.println(sx + ", " + sy);
			// 도망자들이 움직인다.
			for (int i = 0; i < m; i++) {
				int x = fugitives[i].x;
				if (x == -1) continue;
				
				int y = fugitives[i].y;
				int dir = fugitives[i].dir;
				
				// 술래와의 거리가 3 초과인 도망자는 움직일 수 없다.
				if (Math.abs(sx - x) + Math.abs(sy - y) > 3) continue;
				
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				// 현재 진행방향이 범위를 벗어나지 않는 경우
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					// 해당 칸에 술래가 없다면 도망자가 해당 칸으로 이동
					if (nx != sx || ny != sy) {
						fugitives[i].x = nx;
						fugitives[i].y = ny;
					} else {
						// 해당 칸에 술래가 있다면 움직이지 않는다.
						continue;
					}
				} else {
					// 현재 진행방양이 범위를 벗어난 경우
					if (dir == 0) {
						// 상(0) -> 하(2)
						dir = 2;
					} else if (dir == 2) {
						// 하(2) -> 상(0)
						dir = 0;
					} else if (dir == 1) {
						// 우(1) -> 좌(3)
						dir = 3;
					} else if (dir == 3) {
						// 좌(3) -> 우(1)
						dir = 1;
					}
					
					nx = x + dx[dir];
					ny = y + dy[dir];
					
					// 해당 칸에 술래가 없다면 도망자가 해당 칸으로 이동
					if (nx != sx || ny != sy) {
						fugitives[i].x = nx;
						fugitives[i].y = ny;
					} else {
						// 해당 칸에 술래가 있다면 움직이지 않는다.
						continue;
					}
				}
			}
			
			// 술래가 움직인다.
			// 방향전화을 해야하는 경우
			// 정방향(isReverse == false)
			int count = 0;
			if (cnt == 2 && !isReverse) {
				sTarget++;
				cnt = 0;
			} else if (cnt == 2 && isReverse) {
				if (sx == n - 1 && sy == n - 1) {
					cnt = 0;
				} else {
					sTarget--;
					cnt = 0;					
				}
			}
			
			if (!isReverse) {
				
				sx = sx + dx[sDir];
				sy = sy + dy[sDir];
				
				sCount++;
				
				if (sCount == sTarget) {
					sCount = 0;
					sDir = (sDir + 1) % 4;
					cnt++;
				}
				
				// 도망자들을 잡는다.
				int tx1 = sx;
				int ty1 = sy;
				
				int tx2 = tx1 + dx[sDir];
				int ty2 = ty1 + dy[sDir];
				
				int tx3 = tx2 + dx[sDir];
				int ty3 = ty2 + dy[sDir];
				
				// 도망자가 술래의 시야에 있는 경우 잡는다.
				outer: for (int i = 0; i < m; i++) {
					if ((fugitives[i].x == tx1 && fugitives[i].y == ty1) || (fugitives[i].x == tx2 && fugitives[i].y == ty2) || (fugitives[i].x == tx3 && fugitives[i].y == ty3)) {
						for (int j = 0; j < h; j++) {
							if (fugitives[i].x == trees[j].x && fugitives[i].y == trees[j].y) {
								continue outer;
							}
						}
						count++;
						// 잡혔다는 표시(x == -1)
						fugitives[i].x = -1;
					}
				}
				
				// 정뱡향 마지막(0, 0)에 도달한 경우
				if (sx == 0 && sy == 0) {
					cnt = 0;
					sTarget--;
					isReverse = true;
					sDir = 2;
					sCount = 0;
				}
			} else {
				sx = sx + dx[sDir];
				sy = sy + dy[sDir];
				
				sCount++;
				
				if (sCount == sTarget) {
					sCount = 0;
					if (sDir == 0) sDir = 3;
					else sDir--;
					cnt++;
				}
				
				// 도망자들을 잡는다.
				int tx1 = sx;
				int ty1 = sy;
				
				int tx2 = tx1 + dx[sDir];
				int ty2 = ty1 + dy[sDir];
				
				int tx3 = tx2 + dx[sDir];
				int ty3 = ty2 + dy[sDir];
				
				// 도망자가 술래의 시야에 있는 경우 잡는다.
				outer: for (int i = 0; i < m; i++) {
					if ((fugitives[i].x == tx1 && fugitives[i].y == ty1) || (fugitives[i].x == tx2 && fugitives[i].y == ty2) || (fugitives[i].x == tx3 && fugitives[i].y == ty3)) {
						for (int j = 0; j < h; j++) {
							if (fugitives[i].x == trees[j].x && fugitives[i].y == trees[j].y) {
								continue outer;
							}
						}
						count++;
						// 잡혔다는 표시(x == -1)
						fugitives[i].x = -1;
					}
				}
				
				// 역뱡향 마지막(n / 2, n /2)에 도달한 경우
				if (sx == n / 2 && sy == n /2) {
					cnt = 0;
					sTarget = 1;
					isReverse = false;
					sDir = 0;
					sCount = 0;
				}
			}
			
			answer += (t * count);
		}
		
		System.out.println(answer);
	}
	
	static class Fugitive {
		int x;
		int y;
		int dir;
		
		public Fugitive(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static class Tree {
		int x;
		int y;
		
		public Tree(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
