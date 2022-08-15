package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_부분합_1806 {
	
	static int N, S;
	static int left = 0, right = 0, sum = 0, ans = Integer.MAX_VALUE;
	static int[] array;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		while (true) {
			if (left == right) {
				sum = array[left];
				if (sum >= S) {
					ans = 1;
					break;
				}
			}
			
			if (sum >= S) {
				sum -= array[left];
				ans = Math.min(ans, right - left + 1);
				left++;
			} else {
				right++;
				if (right == N) {
					break;
				}
				
				sum += array[right];
			}
		}
		
		if (ans == Integer.MAX_VALUE) {
			ans = 0;
		} 
		
		System.out.println(ans);
	}
}
