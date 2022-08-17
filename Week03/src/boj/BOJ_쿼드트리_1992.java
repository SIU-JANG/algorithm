package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_쿼드트리_1992 {
	
	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		compactScreen(0, N - 1, 0, N - 1);
		
		System.out.println(sb.toString());
	}
	
	static void compactScreen(int startX, int endX, int startY, int endY) {
		sb.append("(");
		boolean flag = false;
		for (int i = startX; i <= endX; i++) {
			for (int j = startY; j <= endY; j++) {
				if (map[i][j] != map[startX][startY]) {
					flag = true;
					break;
				}
			}
			
			if (flag) {
				break;
			}
		}
		
		if (flag) {
			compactScreen(startX, endX / 2, startY, endY / 2);
			compactScreen(startX, endX / 2, (endY / 2) + 1, endY);
			compactScreen((endX / 2) + 1, endX, startY, endY / 2);
			compactScreen((endX / 2) + 1, endX, (endY / 2) + 1, endY);
		} else {
			sb.append(map[startX][startY]);
		}
		
		sb.append(")");
	}
}
