package boj;

import java.util.Scanner;

public class BOJ_사파리월드_2420 {
	
	static long N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextLong();
		M = sc.nextLong();
		
		System.out.println(Math.abs(N - M));
	}
}
