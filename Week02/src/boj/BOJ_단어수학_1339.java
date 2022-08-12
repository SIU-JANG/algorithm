package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_단어수학_1339 {
	
	static int N;
	static String[] str;
	static int[] src;
	static int[] tgt;
	static int[] memoi;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = new String[N];
		src = new int[10];
		memoi = new int[26];
		
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		for (int i = 0; i < 10; i++) {
			src[i] = i;
		}
	}
}
