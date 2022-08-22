package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_격자판의숫자이어붙이기_2819 {
	
	static int TC;
	static int[][] map;
	static Set<String> set;
	
	// delta
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws Exception {
		//	입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			map = new int[4][4];
			set = new HashSet<>();
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//	bfs
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i, j, 1, "");
				}
			}
			
			System.out.println("#" + test_case + " " + set.size());
		}
	}
	
	static void dfs(int x, int y, int cnt, String number) {
		number += Integer.toString(map[x][y]);
		if (cnt == 7) {
			set.add(number);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
				dfs(nx, ny, cnt + 1, number);
			}
		}
	}
}
