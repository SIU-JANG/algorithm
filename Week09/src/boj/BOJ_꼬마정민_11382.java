package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_꼬마정민_11382 {
	
	static long ans;
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 3; i++) {
			ans += Long.parseLong(st.nextToken());
		}
		
		System.out.println(ans);
	}
}
