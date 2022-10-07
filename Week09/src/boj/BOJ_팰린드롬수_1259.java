package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_팰린드롬수_1259 {
	
	static String str;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			str = br.readLine();
			
			if (str.equals("0")) break;
			
			boolean isNo = false;
			for (int left = 0, right = str.length() - 1; left <= right; left++, right--) {
				if (str.charAt(left) != str.charAt(right)) {
					isNo = true;
					System.out.println("no");
					break;
				}
			}
			
			if (!isNo) System.out.println("yes"); 
		}
	}
}