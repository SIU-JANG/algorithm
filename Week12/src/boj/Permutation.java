package boj;

import java.util.Arrays;

public class Permutation {
	
	static int[] src = { 1, 2, 3, 4, 5 };
	static int[] tgt = new int[3];
	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
		perm(0);
	}
	
	static void perm(int tgtIdx) {
		if (tgtIdx == 3) {
			System.out.println(Arrays.toString(tgt));
			
			return;
		}
		
		for (int i = 0; i < src.length; i++) {
			if (select[i]) continue;
			
			select[i] = true;
			tgt[tgtIdx] = src[i];
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}
}
