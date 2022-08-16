package boj;

import java.util.Scanner;

// 완전탐색시 시간초과
public class BOJ_설탕배달_2839 {
	
	static int N;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		ans = 0;
		while (N > 0) {
			if (N % 5 == 0) {
				ans += N / 5;
				break;
			}
			
			N -= 3;
			ans++;
			
			if (N < 0) {
				ans = -1;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
