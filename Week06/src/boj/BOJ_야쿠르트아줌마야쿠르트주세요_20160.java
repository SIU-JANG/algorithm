package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_야쿠르트아줌마야쿠르트주세요_20160 {
	
	static int V, E, u, v, w, start, ans = Integer.MAX_VALUE;
	static List<List<Edge>> vertex = new ArrayList<>();
	
	// 야쿠르트 아줌마가 이동 하는 정점
	static int[] move = new int[10];
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= V; i++) {
			vertex.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			vertex.get(u).add(new Edge(v, w));
			vertex.get(v).add(new Edge(u, w));
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}
		
		start = Integer.parseInt(br.readLine());
		
		// 야쿠르트 아줌마와 시작하자마자 만나는 경우
		if (move[0] == start) {
			ans = move[0];
		}
		
		for (int i = 1; i < 10; i++) {
			
		}
	}
	
	static class Edge {
		int v;
		int c;
		
		public Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
}
