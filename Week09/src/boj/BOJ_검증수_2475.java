package boj;

import java.util.Scanner;

public class BOJ_검증수_2475 {
	
	static int[] arr = new int[5];
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			ans += (int) Math.pow(arr[i], 2);
		}
		
		ans %= 10;
		System.out.println(ans);
	}
}
