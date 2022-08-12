package boj;

import java.util.Scanner;

public class BOJ_123더하기_9095_permutation {
	
	static int T, n, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			n = sc.nextInt();
			
			ans = 0;
			perm(0);
			
			System.out.println(ans);
		}
	}
	
	static void perm(int sum) {
		if (sum == n) {
			ans++;
			return;
		}
		
		if (sum > n) {
			return;
		}
		
		perm(sum + 1);
		perm(sum + 2);
		perm(sum + 3);
	}
}
