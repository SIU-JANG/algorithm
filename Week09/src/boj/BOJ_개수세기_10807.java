package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_개수세기_10807 {
	
	static int N, ans;
	static int[] arr;
	static int v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		v = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			if (arr[i] == v) ans++;
		}
		
		System.out.println(ans);
	}
}
