package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Flood {
	int x;
	int y;
	
	public Flood(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Hedgehog {
	int x;
	int y;
	
	public Hedgehog(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_탈출_3055 {
	
	static int R, C, cnt;
	static char[][] map;
	static boolean[][] checked;
	
	static Queue<Flood> q1;
	static Queue<Hedgehog> q2;
	
	// delta
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		checked = new boolean[R][C];
		
		q1 = new ArrayDeque<>();
		q2 = new ArrayDeque<>();
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '*') {
					q1.add(new Flood(i, j));
				} else if (map[i][j] == 'S') {
					q2.add(new Hedgehog(i, j));
					checked[i][j] = true;
				}
			}
		}
		
		while (true) {
			if (!q1.isEmpty()) {
				int floodCurrentSize = q1.size();
				for (int i = 0; i < floodCurrentSize; i++) {
					Flood curFlood = q1.poll();
					for (int d = 0; d < 4; d++) {
						int nfx = curFlood.x + dx[d];
						int nfy = curFlood.y + dy[d];
						
						if (nfx >= 0 && nfx < R && nfy >= 0 && nfy < C && (map[nfx][nfy] == 'S' || map[nfx][nfy] == '.')) {
							map[nfx][nfy] = '*';
							q1.add(new Flood(nfx, nfy));
						}
					}
				}
			}
			
			boolean canGo = false;
			boolean isSafe = false;
			if (!q2.isEmpty()) {
				int hedgehogCurrentSize = q2.size();
				for (int i = 0; i < hedgehogCurrentSize; i++) {
					Hedgehog curHedgehog = q2.poll();
					// 더 이상 갈 수 없는 경우 체크
					for (int d = 0; d < 4; d++) {
						int nhx = curHedgehog.x + dx[d];
						int nhy = curHedgehog.y + dy[d];
						
						if (nhx >= 0 && nhx < R && nhy >= 0 && nhy < C && !checked[nhx][nhy]) {
							if (map[nhx][nhy] == '.') {
								checked[nhx][nhy] = true;
								q2.add(new Hedgehog(nhx, nhy));
								canGo = true;
							} else if (map[nhx][nhy] == 'D') {
								isSafe = true;
								q2.clear();
								break;
							}
						}
					}
					
					if (isSafe) break;
				}
				
				if (!canGo) {
					q2.clear();
				}
				cnt++;
			}
			
			if (isSafe) {
				System.out.println(cnt);
				break;
			}
			
			if (!canGo) {
				System.out.println("KAKTUS");
				break;
			}
 		}
	}
}
