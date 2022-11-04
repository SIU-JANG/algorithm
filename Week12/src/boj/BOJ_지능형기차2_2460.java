package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_지능형기차2_2460 {
	
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			sum -= Integer.parseInt(st.nextToken());
			sum += Integer.parseInt(st.nextToken());
			
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}
}
