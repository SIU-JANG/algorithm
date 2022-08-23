package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_서로소집합_3289 {
	
	static int TC, n, m;
	static int[] parent;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			parent = new int[n + 1];// 0 dummy
			makeSet();
			
			sb = new StringBuilder("#").append(test_case).append(' ');
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if (op == 0) {
					union(x, y);
				} else if (op == 1) {
					if (findSet(x) == findSet(y)) sb.append('1');
					else sb.append('0');
				}
			}
			
			System.out.println(sb);
			
		}		
	}
	
	// 서로소 집합 관련 메소드들
	static void makeSet() {
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	// 부모를 찾는 ( 부모 번호 == 집합 )
	static int findSet(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (px < py) parent[py] = px;
		else parent[px] = py;
	}
}