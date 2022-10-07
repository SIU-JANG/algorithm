package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_대소문자바꾸기_2744 {
	
	static String str;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') sb.append(Character.toString(str.charAt(i)).toLowerCase());
			else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') sb.append(Character.toString(str.charAt(i)).toUpperCase());
		}
		
		System.out.println(sb.toString());
	}
}
