package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_부분합_1806 {
	
	static int N, S, ans = Integer.MAX_VALUE, sum;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		
		sum = arr[0];
		
		if (sum >= S) {
			System.out.println(1);
			return;
		}
		
		while (right < N && left <= right) {
			if (sum > S) {
				sum -= arr[left];
				left++;
			} else {
				if (right == N - 1) break;
				
				right++;
				sum += arr[right];
			}
			
			if (sum >= S) ans = Math.min(ans, right - left + 1);
		}
		
		if (ans == Integer.MAX_VALUE) ans = 0;
		
		System.out.println(ans);
	}
}
