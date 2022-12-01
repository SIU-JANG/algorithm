package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_가르침_1062 {
	
	static int N, K;
	static List<Character> src = new ArrayList<>();
	static char[] tgt;
	
	static String[] arr;
	
	static int tgtLen, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new String[N];
		
		tgtLen = K - 5;
		
		if (tgtLen < 0) {
			System.out.println(0);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String s = str.substring(4, str.length() - 4);
			
			arr[i] = s;
			
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) != 'a' || s.charAt(j) != 'n' || s.charAt(j) != 't' || s.charAt(j) != 'i' || s.charAt(j) != 'c') {
					if (!src.contains(s.charAt(j))) {
						src.add(s.charAt(j));
					}
				}
			}
		}
		
		tgt = new char[tgtLen];
		
		comb(0, 0);
		
		System.out.println(ans);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == tgtLen) {
			// complete code
			int count = 0;
			for (int i = 0; i < N; i++) {
				boolean possible = true;
				outer: for (int j = 0; j < arr[i].length(); j++) {
					if (arr[i].charAt(j) == 'a' || arr[i].charAt(j) == 'n' || arr[i].charAt(j) == 't' || arr[i].charAt(j) == 'i' || arr[i].charAt(j) == 'c') continue;
					for (int k = 0; k < tgtLen; k++) {
						if (arr[i].charAt(j) == tgt[k]) continue outer;
					}
					
					possible = false;
					break;
				}
				
				if (possible) count++;
			}
			
			ans = Math.max(ans, count);
			
			return;
		}
		
		if (srcIdx == src.size()) return;
		
		tgt[tgtIdx] = src.get(srcIdx);
		
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
}
