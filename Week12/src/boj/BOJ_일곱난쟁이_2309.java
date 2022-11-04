package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_일곱난쟁이_2309 {
	
	static int[] src = new int[9];
	static int[] tgt = new int[7];
	static int[] ans = new int[7];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
			src[i] = sc.nextInt();
		}
		
		comb(0, 0);
		
		Arrays.sort(ans);
		
		for (int a : ans) {
			System.out.println(a);
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == 7) {
			// complete code
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += tgt[i];
			}
			
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					ans[i] = tgt[i];
				}
			}
			
			return;
		}
		
		if (srcIdx == 9) return;
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
}
