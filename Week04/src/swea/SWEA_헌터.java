package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_헌터 {
	
	static int TC, N, srcSize;
	static int[][] map;
	static int[] src;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			srcSize = 0;
			
			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0) srcSize++;
				}
			}
			
			src = new int[srcSize];
			for (int i = 0; i < srcSize; i++) {
				src[i] = i;
			}
		}
	}
	
//	static boolean np() {
//		int i = src.length - 1;
//		while (i > 0 && src[i - 1] >= src[i]) --i;
//		
//		if (i == 0) return false;
//		
//		int j = src.length - 1;
//		while (src[i - 1] >= )
//	}
}
