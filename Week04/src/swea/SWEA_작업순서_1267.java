package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// bfs
public class SWEA_작업순서_1267 {
	
	static int TC = 10, V, E;
	static int[] indegree;	// 진입 차수 관리 배열
	
	static boolean[][] matrix;
	static Queue<Integer> q = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			indegree = new int[V + 1];
			matrix = new boolean[V + 1][V + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				matrix[from][to] = true;
				indegree[to]++;
			}
			
			sb.append('#').append(test_case).append(' ');
			
			// 위상 정렬
			// 전입 차수가 0 인 항목을 queue 에 넣고 시작
			for (int i = 1; i <= V; i++) {
				if(indegree[i] == 0) q.offer(i);
			}
			
			while (!q.isEmpty()) {
				int v = q.poll();
				sb.append(v).append(' ');
				for (int i = 1; i <= V; i++) {
					if (matrix[v][i]) {
						indegree[i]--;
						if (indegree[i] == 0) q.offer(i);
					}
				}
			}
			
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
}
