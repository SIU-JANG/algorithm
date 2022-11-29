package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class BOJ_괄호의값_2504 {
	
	static String str;
	static int ans;
	static Stack<Integer> st = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c == '(') {
				st.push(-1);
			} else if (c == '[') {
				st.push(-2);
			} else if (c == ')') {
				if (st.isEmpty()) {
					System.out.println(0);
					return;
				}
				
				int n = st.pop();
				
				if (n == -2) {
					System.out.println(0);
					return;
				} else if (n == -1) {
					st.push(2);
				} else {
					int xy = n;
					while (true) {
						if (st.isEmpty()) {
							System.out.println(0);
							return;
						}
						int next = st.peek();
						
						if (next == -1) {
							st.pop();
							st.push(2 * xy);
							break;
						} else if (next == -2) {
							System.out.println(0);
							return;
						} else {
							xy += st.pop();
						}
					}
				}
			} else if (c == ']') {
				if (st.isEmpty()) {
					System.out.println(0);
					return;
				}
				
				int n = st.pop();
				
				if (n == -1) {
					System.out.println(0);
					return;
				} else if (n == -2) {
					st.push(3);
				} else {
					int xy = n;
					while (true) {
						if (st.isEmpty()) {
							System.out.println(0);
							return;
						}
						int next = st.peek();
						
						if (next == -2) {
							st.pop();
							st.push(3 * xy);
							break;
						} else if (next == -1) {
							System.out.println(0);
							return;
						} else {
							xy += st.pop();
						}
					}
				}
			}
		}
		while (!st.isEmpty()) {
			if (st.peek() < 0) {
				System.out.println(0);
				return;
			}
			ans += st.pop();
		}
		
		System.out.println(ans);
	}
}
