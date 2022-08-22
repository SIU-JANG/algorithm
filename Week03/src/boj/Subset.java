package boj;

import java.util.Arrays;

public class Subset {
	
	static int[] src = { 1, 2, 3, 4, 5 };
	static boolean[] select = new boolean[src.length];
	static int COUNT;
	
	public static void main(String[] args) {
		subset(0);
		System.out.println(COUNT);
	}
	
	static void subset(int srcIdx) {
		if (srcIdx == src.length) {
			COUNT++;
			System.out.println(Arrays.toString(select));
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);
		
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}
}
