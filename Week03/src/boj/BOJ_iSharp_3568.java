package boj;

import java.util.Scanner;

public class BOJ_iSharp_3568 {
	
	static String[] strArr;
	
	public static void main(String[] args) {
		//	1. 입력
		Scanner sc = new Scanner(System.in);
		
		//	2. 빈칸으로 쪼개기
		strArr = sc.nextLine().split(" ");
		
		for (int i = 1; i < strArr.length; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(strArr[0]);
			
			String s = strArr[i];
			int sliceIdx = 0;
			for (int j = s.length() - 1; j >= 0; j--) {
				if ((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')) {
					sliceIdx = j + 1;
					break;
				} else if (s.charAt(j) == '[') {
					sb.append(']');
				} else if (s.charAt(j) == ']') {
					sb.append('[');
				} else if (s.charAt(j) == '*'){
					sb.append('*');
				} else if (s.charAt(j) == '&') {
					sb.append('&');
				}
			}
			
			sb.append(" ");
			sb.append(s.substring(0, sliceIdx));
			sb.append(';');
			System.out.println(sb);
		}
	}
}
