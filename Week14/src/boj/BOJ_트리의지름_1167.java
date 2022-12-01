package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_트리의지름_1167 {
	
	static int V;
	static List<Node> list[];
	
	// dijkstra
	static PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> (n2.cost - n1.cost));
	static boolean[] checked;
	static int[] costs;
	
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V + 1];
		checked = new boolean[V + 1];
		costs = new int[V + 1];
		
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		int parent = 0;
		int child = 0;
		int cost = 0;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			
			parent = Integer.parseInt(st.nextToken());
			while (true) {
				child = Integer.parseInt(st.nextToken());
				if (child == -1) break;
				
				cost = Integer.parseInt(st.nextToken());
				
				list[parent].add(new Node(child, cost));
				list[child].add(new Node(parent, cost));
			}
		}
		
		pq.clear();
		Arrays.fill(costs, Integer.MIN_VALUE);
		Arrays.fill(checked, false);
		
		costs[1] = 0;
		pq.add(new Node(1, 0));
		
		int longestIdx = dijkstra(1)[1];
		
		pq.clear();
		Arrays.fill(costs, Integer.MIN_VALUE);
		Arrays.fill(checked, false);
		
		costs[longestIdx] = 0;
		pq.add(new Node(longestIdx, 0));
		
		ans = dijkstra(longestIdx)[0];
				
//		for (int i = 1; i < V; i++) {
//			for (int j = i + 1; j <= V; j++) {				
//				pq.clear();
//				Arrays.fill(costs, Integer.MIN_VALUE);
//				Arrays.fill(checked, false);
//				
//				costs[i] = 0;
//				pq.add(new Node(i, 0));
//				
//				int sum = dijkstra(i, j);
//				
//				ans = Math.max(ans, sum);
//			}
//		}
		
		System.out.println(ans);
	}
	
	static int[] dijkstra(int start) {
		int[] ret = { Integer.MIN_VALUE, 0 };
		
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			
			if (checked[n.child] || n.cost < costs[n.child]) continue;
			
			checked[n.child] = true;
			
			for (Node nn : list[n.child]) {
				if (!checked[nn.child] && costs[nn.child] < costs[n.child] + nn.cost) {
					costs[nn.child] = costs[n.child] + nn.cost; 
					pq.add(new Node(nn.child, costs[nn.child]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (ret[0] < costs[i]) {
				ret[0] = costs[i];
				ret[1] = i;
			}
		}
		
		return ret;
	}
	
//	static void dfs(int idx, int sum) {
//		for (Node n : list[idx]) {
//			if (!checked[n.child]) {
//				checked[n.child] = true; 
//				dfs(n.child, sum + n.cost);
//			}
//		}
//		
//		ans = Math.max(ans, sum);
//	}
	
	static class Node {
		int child;
		int cost;
		
		public Node (int child, int cost) {
			this.child = child;
			this.cost = cost;
		}
	}
}
