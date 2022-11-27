package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_부분수열의합_1182 {
	
	static int N, S;
	static int[] arr;
	
	// subset
	static boolean[] select;
	
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		select = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		
		System.out.println(answer);
	}
	
	static void subset(int srcIdx) {
		if (srcIdx == N) {
			// complete code
			calc();
			
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);
		
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}
	
	static void calc() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (select[i]) {
				sum += arr[i];
			}
		}
		
		if (sum == S) answer++;
	}
}
