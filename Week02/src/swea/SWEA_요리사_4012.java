package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_요리사_4012 {
	
	static int T, N, min;
	static int[][] map;
	static int[] src;
	static int[] tgt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			src = new int[N];
			for (int i = 0; i < N; i++) {
				src[i] = i;
			}
			tgt = new int[N / 2];
			
			min = Integer.MAX_VALUE;
			comb(0, 0);
			System.out.println("#" + test_case + " " + min);
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == tgt.length) {
			// complete code
			int sumA = 0;
			int sumB = 0;
			
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					if (i == j) continue;
					
					sumA += map[tgt[i]][tgt[j]];
				}
			}
			
			int[] tgt2 = new int[N / 2];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				boolean flag = false;
				for (int j = 0; j < N / 2; j++) {
					if (src[i] == tgt[j]) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					tgt2[idx++] = i;
				}
			}
			
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					if (i == j) continue;
					
					sumB += map[tgt2[i]][tgt2[j]];
				}
			}
			
			min = Math.min(min, Math.abs(sumA - sumB));
			
			return;
		}
		
		if (srcIdx == src.length) {
			return;
		}
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
}
