package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_햄버거다이어트_5215_3 {
	
	static int T, N, L, max;
	static Item[] src;
	static boolean[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			max = 0;
			
			src = new Item[N]; 
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				src[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); 
			}
			
			selected = new boolean[N];
			subset(0);
			
			System.out.println("#" + test_case + " " + max);
		}
	}
	
	static class Item {
		int score;
		int kcal;
		
		public Item(int score, int kcal) {
			this.score = score;
			this.kcal = kcal;
		}
	}
	
	static void subset(int srcIdx) {
		if (srcIdx == N) {
			int score = 0;
			int kcal = 0;
			
			for (int i = 0; i < selected.length; i++) {
				if (selected[i]) {
					score += src[i].score;
					kcal += src[i].kcal;
				}
			}
			
			if (kcal <= L) {
				max = Math.max(max, score);
			}
			
			return;
		}
		
		selected[srcIdx] = true;
		subset(srcIdx + 1);
		
		selected[srcIdx] = false;
		subset(srcIdx + 1);
	}
}
