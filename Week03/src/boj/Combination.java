package boj;

import java.util.Arrays;

public class Combination {
	
	static int COUNT;
	static int[] src = { 1, 2, 3, 4, 5 };
	static int[] tgt = new int[3];
	
	public static void main(String[] args) {
		comb(0, 0);
		System.out.println(COUNT);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == tgt.length) {
			// complete code
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			
			return;
		}
		
		for (int i = srcIdx; i < src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb(i + 1, tgtIdx + 1);
		}
	}
	
	static void comb_2(int srcIdx, int tgtIdx) {
		if (tgtIdx == tgt.length) {
			COUNT++;
			System.out.println(Arrays.toString(tgt));
			return;
		} 
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
}
