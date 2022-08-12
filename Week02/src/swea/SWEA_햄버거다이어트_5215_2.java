package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_햄버거다이어트_5215_2 {
	
	static int T, N, L, max;
	static Item[] src;
	static Item[] tgt;
	
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
			
			for (int i = 1; i <= N; i++) {
				tgt = new Item[i];
				comb(0, 0);
			}
			
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
	
	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == tgt.length) {
			// complete code : L 을 초과하지 않으면서 최대값을 따져본다.
			int kcal = 0;
			int score = 0;
			
			// 칼로리의 합
			for (int i = 0; i < tgtIdx; i++) {
				kcal += tgt[i].kcal;
				score += tgt[i].score;
			}
			
			if (kcal <= L) {
				max = Math.max(max, score);
			}
			
			return;
		}
		
		if (srcIdx == N) {
			return;
		}
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
}
