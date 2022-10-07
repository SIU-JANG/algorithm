package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_키순서_5643 {
	
	// N : 학생 수, M : 키 비교 횟수
	static int T, N, M, ans;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			arr = new int[N + 1][N + 1];
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				arr[v][w] = 1;
			}
			
			// floyd-warshall
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1;
					}
				}
			}
			
			ans = 0;
			
			for (int i = 1; i <= N; i++) {
				int cnt = 0;
				for (int j = 1; j <= N; j++) {
					if (i == j) continue;
					
					if (arr[i][j] == 1 || arr[j][i] == 1) cnt++;
				}
				
				if (cnt == N - 1) ans++;
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
