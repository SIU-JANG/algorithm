package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_문자열_9086 {
	
	static int T;
	static String str;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			str = br.readLine();
			
			System.out.print(str.charAt(0));
			System.out.println(str.charAt(str.length() - 1));
		}
	}
}
