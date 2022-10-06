package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_맥주마시면서걸어가기_9205 {
	
	static int T, n;
	static List<int[]> map;
	static boolean[][] checked;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			
			map = new ArrayList<>();
			checked = new boolean[n + 2][n + 2];
			
			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int[] temp = new int[2];
				temp[0] = Integer.parseInt(st.nextToken());
				temp[1] = Integer.parseInt(st.nextToken());
				
				map.add(temp);
			}
			
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					if (i == j) continue;
					
					int dist = Math.abs(map.get(i)[0] - map.get(j)[0]) + Math.abs(map.get(i)[1] - map.get(j)[1]);
					
					if (dist <= 1000) checked[i][j] = true;
				}
			}
			
			// floyd warshall
			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					for (int j = 0; j < n + 2; j++) {
						if (checked[i][k] && checked[k][j]) checked[i][j] = true;
					}
				}
			}
			
			if (checked[0][n + 1]) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}
}
