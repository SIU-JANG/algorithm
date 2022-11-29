package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_빗물_14719 {
	
	static int H, W, ans;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < W; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			for (int j = H - 1; j >= H - n; j--) {
				map[j][i] = 1;
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 0) {
					if (check(i, j)) {
						ans++;
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	static boolean check(int x, int y) {
		boolean right = false;
		boolean left = false;
		
		for (int i = y; i < W; i++) {
			if (map[x][i] == 1) {
				right = true;
				break;
			}
		}
		
		for (int i = y; i >= 0 ; i--) {
			if (map[x][i] == 1) {
				left = true;
				break;
			}
		}
		
		if (right && left) return true;
		else return false;
	}
}
