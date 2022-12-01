package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_트리_1068 {
	
	static int N;
	static Node[] tree;
	
	static int target, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		tree = new Node[N + 1];
		
		for (int i = 0; i <= N; i++) {
			tree[i] = new Node(i);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = 0;
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			
			if (parent == -1) {
				root = i;
				continue;
			}
			
			tree[parent].children.add(tree[i]);
		}
		
		target = Integer.parseInt(br.readLine());
		
		if (target != root) {
			delete(root);
			dfs(root);
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int node) {
		if (tree[node].children.isEmpty()) {
			ans++;
			return;
		}
		
		for (Node child : tree[node].children) {
			dfs(child.idx);
		}
	}
	
	static void delete(int node) {
		for (Node child : tree[node].children) {
			if (child.idx == target) {
				tree[node].children.remove(child);
				return;
			}
			delete(child.idx);
		}
	}
	
	static class Node {
		int idx;
		ArrayList<Node> children = new ArrayList<>();
		
		public Node (int idx) {
			this.idx = idx;
		}
	}
}