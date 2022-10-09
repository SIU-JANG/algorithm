package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_낚시왕_17143 {
	
	static int R, C, M, r, c, s, d, z, ans;
	static int[][] map;
	static Shark[] sharks;
	
	// delta ( 0 : 상, 1 : 하, 2 : 우, 3 : 좌 )
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		sharks = new Shark[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			sharks[i] = new Shark(r - 1, c - 1, s, d, z);
			
			// 상어가 있으면 1
			map[r - 1][c - 1] += 1;
		}
		
		// 낚시왕이 이동한다.
		for (int i = 0; i < C; i++) {
			int sharkLo = -1;
			
			// 낚시왕이 있는 열에 상어가 있는지 체크해서 있다면 잡는다.
			for (int j = 0; j < R; j++) {
				if (map[j][i] == 1) {
					sharkLo = j;
					break;
				}
			}
			
			// 만약 상어가 있다면 낚시왕이 땅 가장 큰처에 있는 상어를 잡는다. 
			if (sharkLo != -1) {
				getShark(sharkLo, i);
			}
			
			// 상어가 이동한다.
			for (int j = 0; j < sharks.length; j++) {
				if (sharks[j] != null) {
					move(j, sharks[j]);
				}
			}
			
			// 같은 칸에 상어가 두 마리 이상 있다면 크기가 큰 상어만 남는다.
			for (int k = 0; k < R; k++) {
				for (int l = 0; l < C; l++) {
					if (map[k][l] >= 2) {
						eat(k, l);
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static void eat(int x, int y) {
		List<Shark> sameLoShark = new ArrayList<>();
		
		for (int i = 0; i < sharks.length; i++) {
			if (sharks[i] != null && sharks[i].x == x && sharks[i].y == y) {
				sameLoShark.add(sharks[i]);
			}
		}
		
		// *************
		Collections.sort(sameLoShark, (s1, s2) -> s2.z - s1.z);
		
		for (int i = 1; i < sameLoShark.size(); i++) {
			for (int j = 0; j < sharks.length; j++) {
				if (sharks[j] != null && sharks[j].s == sameLoShark.get(i).s && sharks[j].d == sameLoShark.get(i).d && sharks[j].z == sameLoShark.get(i).z) {
					sharks[j] = null;
					map[x][y] -= 1;
				} 
			}
		}
	}
	
	static void move(int index, Shark shark) {		
		int x = shark.x;
		int y = shark.y;
		int s = shark.s;
		int d = shark.d;
		int z = shark.z;
		
		map[x][y] -= 1;
		
		for (int i = 0; i < s; i++) {
			if (d == 1) {
				// 상
				// 앞이 벽이라면 방향을 반대로 돌린다.
				if (x - 1 < 0) {
					d = 2;
					i--;
				} else {
					x = x - 1;
				}
			} else if (d == 2) {
				// 하
				if (x + 1 >= R) {
					d = 1;
					i--;
				} else {
					x = x + 1;
				}
			} else if (d == 3) {
				// 우
				if (y + 1 >= C) {
					d = 4;
					i--;
				} else {
					y = y + 1;
				}
			} else if (d == 4) {
				// 좌
				if (y - 1 < 0) {
					d = 3;
					i--;
				} else {
					y = y - 1;
				}
			}
		}
		
		map[x][y] += 1;
		sharks[index] = new Shark(x, y, s, d, z);
	}
	
	static void getShark(int x, int y) {		
		for (int i = 0; i < sharks.length; i++) {
			if (sharks[i] != null && sharks[i].x == x && sharks[i].y == y) {
				ans += sharks[i].z;
				sharks[i] = null;
				break;
			}
		}
		
		map[x][y] = 0;
	}
	
	static class Shark {
		int x;
		int y;
		// s : 속력
		int s;
		// d : 이동 방향
		int d;
		// z : 크기
		int z;
		
		public Shark (int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
