package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_단어길이재기_2743 {
	
	static String str;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		System.out.println(str.length());
	}
}
