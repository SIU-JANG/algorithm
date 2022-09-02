package boj;

import java.util.Scanner;

public class BOJ_조합_2407 {
	
	static int n, m;
	static long[][] memoi = new long[101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 100; i++) {
			memoi[i][1] = i;
		}
		
		for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= 100; j++) {
				if (i >= j) {
					memoi[i][j] = memoi[i - 1][j] + memoi[i - 1][j - 1];
					System.out.println(i + "C" + j + " = " + memoi[i][j]);
				}
			}
		}
	}
}
