package etc;

public class Subset {
	
	static int COUNT = 0;
	static int[] src = { 1, 2, 3, 4, 5 };
	static boolean[] selected = new boolean[src.length];
	
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
		
		selected[srcIdx] = true;
		subset(srcIdx + 1);
		
		selected[srcIdx] = false;
		subset(srcIdx + 1);
	}
	
	static void printSubset() {
		for (int i = 0; i < selected.length; i++) {
			if (selected[i]) {
				System.out.print(src[i] + " ");
			}
		}
		System.out.println();
	}
}
