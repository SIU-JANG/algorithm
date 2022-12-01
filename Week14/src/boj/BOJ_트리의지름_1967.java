package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_트리의지름_1967 {
	
	static int n;
	static List<Node> list[];
	
	static boolean[] checked;
	
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n + 1];
		checked = new boolean[n + 1];
		
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[parent].add(new Node(child, cost));
			list[child].add(new Node(parent, cost));
		}
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(checked, false);
			checked[i] = true;
			dfs(i, 0);
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int idx, int sum) {
		for (Node n : list[idx]) {
			if (!checked[n.child]) {
				checked[n.child] = true;
				dfs(n.child, sum + n.cost);
			}
		}
		
		ans = Math.max(ans, sum);
	}
	
	static class Node {
		int child;
		int cost;
		
		public Node (int child, int cost) {
			this.child = child;
			this.cost = cost;
		}
	}
}
