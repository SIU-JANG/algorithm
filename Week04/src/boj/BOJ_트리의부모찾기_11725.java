package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node1 {
	List<Integer> child = new ArrayList<>();
	int parent;
	
	public Node1(int parent, int child) {
		this.parent = parent;
		this.child.add(child);
	}
}

public class BOJ_트리의부모찾기_11725 {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
		}
	}
}
