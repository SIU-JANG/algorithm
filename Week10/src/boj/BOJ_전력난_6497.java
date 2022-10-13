package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_전력난_6497 {
	
	static int m, n, x, y, z;
	static Edge[] edges;
	
	// union-find
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if (m == 0 && n == 0) break;
			
			edges = new Edge[n];
			parent = new int[m];
			
			int sum = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				sum += c;
				
				edges[i] = new Edge(v, w, c);
			}
						
			Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);
			
			makeSet();
			
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				Edge e = edges[i];
				
				if (union(e.v, e.w)) {
					cnt++;
					sum -= e.c;
				}
				
				if (cnt == m - 1) break;
			}
			
			System.out.println(sum);
		}
	}
	
	static void makeSet() {
		for (int i = 0; i < m; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if (parent[x] == x) return x;
		
		return parent[x] = findSet(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if (px == py) return false;
		
		if (px < py) parent[py] = px;
		else parent[px] = py;
		
		return true;
	}
	
	static class Edge {
		int v;
		int w;
		int c;
		
		public Edge(int v, int w, int c) {
			this.v = v;
			this.w = w;
			this.c = c;
		}
	}
}
