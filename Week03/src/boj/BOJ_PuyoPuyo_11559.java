package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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

public class BOJ_PuyoPuyo_11559 {
	
	static int ans;
	static char[][] map = new char[12][];
	static boolean[][] checked;
	static Queue<Color> q = new ArrayDeque<>();
	
	//	delta
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	// bfs를 실행한 좌표를 List에 저장
	static List<Color> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
				
		ans = 0;
		boolean flag = false;
		while (!flag) {
			flag = true;
			//	1. bfs로 4개 이상 모이면 지우기 (. 으로 변경)
			checked = new boolean[12][6];
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.' && !checked[i][j]) {
						bfs(i, j);
						if (list.size() >= 4) {
							for (int a = 0; a < list.size(); a++) {
								map[list.get(a).x][list.get(a).y] = '.';
							}
							flag = false;
						}
						list.clear();
					}
				}
			}
			
			//	2. 아래가 비어있다면 (.이라면) 밑으로 내리기
			for (int i = 11; i >= 0; i--) {
				for (int j = 5; j >= 0; j--) {
					if (map[i][j] != '.') {
						fall(i, j, map[i][j]);
					}
				}
			}
			if (!flag) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	static void bfs(int x, int y) {		
		checked[x][y] = true;
		q.add(new Color(x, y, map[x][y]));
		
		while (!q.isEmpty()) {
			int currentSize = q.size();
			for (int i = 0; i < currentSize; i++) {
				Color current = q.poll();
				list.add(current);
				for (int d = 0; d < 4; d++) {
					int nx = current.x + dx[d];
					int ny = current.y + dy[d];
					
					if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && map[nx][ny] == current.color && !checked[nx][ny]) {
						checked[nx][ny] = true;
						q.add(new Color(nx, ny, map[nx][ny]));
					}
				}
			}
		}
	}
	
	static void fall(int x, int y, char color) {
		while (true) {
			int nx = x + 1;
			if (nx < 12 && map[nx][y] == '.') {
				map[nx][y] = color;
				map[x][y] = '.';
				x = nx;
			} else {
				break;
			}
		}
	}
}
