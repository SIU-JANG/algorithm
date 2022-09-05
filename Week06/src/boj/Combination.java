package boj;

import java.util.Arrays;

public class Combination {
	
	static int[] src = { 1, 2, 3, 4, 5 };
	static int[] tgt = new int[3];
	
	static int COUNT;
	
	public static void main(String[] args) {
		comb2(0, 0);
		
		System.out.println(COUNT);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == 3) {
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			
			return;
		}
		
		for (int i = srcIdx; i < src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb(i + 1, tgtIdx + 1);
		}
	}
	
	static void comb2(int srcIdx, int tgtIdx) {
		if (tgtIdx == 3) {
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			
			return;
		}
		
		if (srcIdx == 5) return;
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
}
