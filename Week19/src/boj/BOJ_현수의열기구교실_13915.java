package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_현수의열기구교실_13915 {
	
	static int N, M;
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		while ((s = br.readLine()) != null) {
			N = Integer.parseInt(s);
			set.clear();
			
			for (int i = 0; i < N; i++) {
				M = Integer.parseInt(br.readLine());
				int bit = 0;
				
				while (M > 0) {
					bit |= (1 << ((M % 10) - 1));
					M /= 10;
				}
				
				set.add(bit);
			}
			
			System.out.println(set.size());
		} 
	}
}
