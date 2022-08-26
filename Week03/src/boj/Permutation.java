package boj;

import java.util.Arrays;

public class Permutation {
	
	static int COUNT;
	static int[] src = { 1, 2, 3, 4, 5 };
	static int[] tgt = new int[3];
	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
		perm(0);
		System.out.println(COUNT);
	}
	
	static void perm(int tgtIdx) {
		if (tgtIdx == tgt.length) {
			// complete code
			
			return;
		}
		
		for (int i = 0; i < src.length; i++) {
			if (select[i]) continue;
			
			tgt[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx + 1);
			
			select[i] = false;
		}
	}
}
