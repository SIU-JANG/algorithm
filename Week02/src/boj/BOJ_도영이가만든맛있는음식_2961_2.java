package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_도영이가만든맛있는음식_2961_2 {
	
	static int N, ans;
	static Ingredient[] src;
	static boolean[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		src = new Ingredient[N];
		selected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i] = new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		ans = Integer.MAX_VALUE;
		subset(0);
		System.out.println(ans);
	}
	
	static void subset(int srcIdx) {
		if (srcIdx == N) {
			int sourMultiple = 1;
			int bitterSum = 0;
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				if (!selected[i]) {
					continue;
				}
				
				sourMultiple *= src[i].sour;
				bitterSum += src[i].bitter;
				cnt++;
			}
			
			if (cnt == 0) {
				return;
			}
			
			ans = Math.min(ans, Math.abs(sourMultiple - bitterSum));
			return;
		}
		
		selected[srcIdx] = true;
		subset(srcIdx + 1);
		
		selected[srcIdx] = false;
		subset(srcIdx + 1);
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
