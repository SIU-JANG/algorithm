package etc;

import java.util.Arrays;

public class Combination {
	
	static int COUNT = 0;
	static int[] src = { 1, 2, 3, 4, 5 };
	static int[] tgt = new int[3];
	
	public static void main(String[] args) {
		comb2(0, 0);
		System.out.println(COUNT);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == tgt.length) {
			COUNT++;
			System.out.println(Arrays.toString(tgt));
			return;
		}
		
		for (int i = srcIdx; i < src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb(i + 1, tgtIdx + 1);
		}
	}
	
	static void comb2(int srcIdx, int tgtIdx) {
		if (tgtIdx == tgt.length) {
			COUNT++;
			System.out.println(Arrays.toString(tgt));
			return;
		}
		
		if (srcIdx == src.length) {
			return;
		}
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb2(srcIdx + 1, tgtIdx + 1);
		comb2(srcIdx + 1, tgtIdx);
	}
}
