package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_회전초밥_15961 {
	
	static int N, d, k, c, ans = Integer.MIN_VALUE;
	static int[] sushi, dArray;
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi = new int[N];
		dArray = new int[d + 1];
		
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		// sliding window
		int left = 0, right = left + (k - 1);
		int cnt = 0;
		
		dArray[c]++;
		if (dArray[c] == 1) cnt++;
		
		for (int i = left; i <= right; i++) {
			dArray[sushi[i]]++;
			
			if (dArray[sushi[i]] == 1) cnt++;
		}
		
		ans = Math.max(ans, cnt);
				
		if (right == N - 1) {
			System.out.println(ans);
			return;
		}
				
		while (true) {
			right++;
			left++;
			
			dArray[sushi[right]]++;
			if (dArray[sushi[right]] == 1) cnt++;
			
			dArray[sushi[left - 1]]--;
			if (dArray[sushi[left - 1]] == 0) cnt--;
						
			ans = Math.max(ans, cnt);
						
			if (right == N - 1) break;
		}
			
		System.out.println(ans);
	}
}
