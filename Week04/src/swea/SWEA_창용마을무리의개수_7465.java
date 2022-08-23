package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_창용마을무리의개수_7465 {
	
	static int TC, N, M, ans;
	static int[][] graph;
	static boolean[] checked;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			ans = 0;
			
			graph = new int[N + 1][N + 1];
			checked = new boolean[N + 1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a][b] = 1;
				graph[b][a] = 1;
			}
			
			for (int i = 1; i <= N; i++) {
				if (!checked[i]) {
					checked[i] = true;
					dfs(i);
					ans++;
				}
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	static void dfs(int person) {
		for (int i = 1; i <= N; i++) {
			if (graph[person][i] == 1 && !checked[i]) {
				checked[i] = true;
				dfs(i);
			}
		}
	}
}
