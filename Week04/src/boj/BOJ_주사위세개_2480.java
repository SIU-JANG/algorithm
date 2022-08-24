package boj;

import java.util.Scanner;

public class BOJ_주사위세개_2480 {
	
	static int d1, d2, d3, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		d1 = sc.nextInt();
		d2 = sc.nextInt();
		d3 = sc.nextInt();
		
		if (d1 == d2 && d2 == d3) {
			ans = 10_000 + (d1 * 1_000);
		} else if (d1 == d2) {
			ans = 1_000 + (d1 * 100);
		} else if (d2 == d3) {
			ans = 1_000 + (d2 * 100);
		} else if (d3 == d1) {
			ans = 1_000 + (d3 * 100);
		} else {
			ans = Math.max(d1, Math.max(d2, d3)) * 100;
		}
		
		System.out.println(ans);
	}
}
