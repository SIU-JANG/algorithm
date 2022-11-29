package boj;

import java.util.Scanner;

public class BOJ_쉽게푸는문제_1292 {
	
	static int A, B, ans;
	static int[] arr = new int[1000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		
		int val = 1;
		int count = 0;
		for (int i = 0; i < B; i++) {
			arr[i] = val;
			
			count++;
			if (count == val) {
				val++;
				count = 0;
			}
		}
		
		for (int i = A - 1; i < B; i++) {
			ans += arr[i];
		}
		
		System.out.println(ans);
	}
}
