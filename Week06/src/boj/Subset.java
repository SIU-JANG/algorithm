package boj;

public class Subset {
	
	static int[] src = { 1, 2, 3, 4, 5 };
	static boolean[] select = new boolean[5];
	
	static int COUNT;
	
	public static void main(String[] args) {
		subset(0);
		
		System.out.println(COUNT);
	}
	
	static void subset(int srcIdx) {
		if (srcIdx == src.length) {
			printSubset();
			COUNT++;
			
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);
		
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}
	
	static void printSubset() {
		for (int i = 0; i < select.length; i++) {
			if (select[i]) System.out.print(src[i] + " ");
		}
		
		System.out.println();
	}
}
