package boj;

import java.util.Scanner;

public class BOJ_킹퀸룩비숍나이트폰_3003 {
	
	static int[] chess = { 1, 1, 2, 2, 2, 8 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			System.out.print(chess[i] - sc.nextInt() + " ");
		}
		System.out.println();
	}
}
