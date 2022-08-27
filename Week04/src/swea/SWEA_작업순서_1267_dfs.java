package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// dfs
public class SWEA_작업순서_1267_dfs {
	
	static int TC = 10, V, E;
	static int[] indegree;	// 진입 차수 관리 배열
	
	static boolean[][] matrix;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			matrix = new boolean[V + 1][V + 1];
			visit = new boolean[V + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				matrix[from][to] = true;
			}
			
			sb.append('#').append(test_case).append(' ');
			
			// 위상 정렬
			for (int i = 1; i <= V; i++) { // 모든 정점에서 dfs() 시도
				// 이미 방문한 선행된 정점이 있으면 skip
				if (!visit[i]) dfs(i);
			}
			
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int v) {
		visit[v] = true;
		// v 로 들어오는 정점
		for (int i = 1; i <= V; i++) {
			if (matrix[i][v] && !visit[i]) dfs(i);
		}
		
		sb.append(v).append(' ');
	}
}
