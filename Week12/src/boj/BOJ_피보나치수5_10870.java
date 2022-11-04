package boj;

import java.util.Scanner;

public class BOJ_피보나치수5_10870 {
	
	static int n;
	static int[] fibo = new int[21];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		fibo[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
		
		System.out.println(fibo[n]);
	}
}
