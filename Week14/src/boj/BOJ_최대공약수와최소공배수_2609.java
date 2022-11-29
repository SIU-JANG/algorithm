package boj;

import java.util.Scanner;

public class BOJ_최대공약수와최소공배수_2609 {
	
	static int N, M;
	static int gcdVal, lcmVal;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		gcdVal = gcd(N, M);
		lcmVal = (N * M) / gcdVal;
		
		System.out.println(gcdVal);
		System.out.println(lcmVal);
	}
	
	static int gcd(int n, int m) {		
		if (n > m) {
			if (n % m == 0) return m;
			else return gcd(m, n % m);
		} else if (n == m) {
			return n;
		} else {
			if (m % n == 0) return n;
			else return gcd(n, m % n);
		}
	}
}
