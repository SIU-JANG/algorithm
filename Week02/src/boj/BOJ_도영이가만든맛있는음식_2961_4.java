package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_도영이가만든맛있는음식_2961_4 {
	
	static int N, min;
	static int[][] src;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		src = new int[N][2];
		select = new boolean[N];
		
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());
		}
		
		subset();
		
		System.out.println(min);
	}
	
	static void subset(int srcIdx) {
		if (srcIdx == N) {
			int sin = 1;
			int ssn = 0;
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				if (!select[i]) {
					continue;
				}
				
				sin *= src[i][0];
				ssn += src[i][1];
				cnt++;
			}
			
			if (cnt == 0) {
				return;
			}
			
			min = Math.min(min, Math.abs(sin - ssn));
			return;
		}
		
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if (i & (1 << j)) {
					select[j] = true;
				}
			}
		}
	}
	
	static class Ingredient {
		int sour;
		int bitter;
		
		Ingredient(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
	}
}
