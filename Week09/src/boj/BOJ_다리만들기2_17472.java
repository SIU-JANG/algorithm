package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_다리만들기2_17472 {
	
	static int N, M, c = 1, ans;
	static int[][] map;
	static boolean[][] checked;
	
	// 조합
	static int[] src;
	static int[] tgt;
	
	// delta
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	// kruskal
	static List<Edge> edges = new ArrayList<>();
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		checked = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 각 섬을 번호로 표시한다.(dfs)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!checked[i][j] && map[i][j] != 0) {
					dfs(i, j);
					c++;
				}
			}
		}
		
		// ------------------------ 섬 그리기 확인
		System.out.println("-----------------섬 확인-----------------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		// 2. 각 섬들끼리 다리를 만들 수 있으면 만드는 경우를 모두 저장한다.(조합)
		src = new int[c - 1]; // 섬은 c - 1개만큼 있다.
		tgt = new int[2];
		for (int i = 0; i < c - 1; i++) {
			src[i] = i + 1;
		}		
		
		// ------------------------- src 확인
		System.out.println("-------------src 확인------------------");
		for (int i = 0; i < src.length; i++) {
			System.out.print(src[i] + " ");
		}
		System.out.println();
		
		System.out.println("------------------- comb 확인--------------------");
		comb(0, 0);
		
		System.out.println("------------------ edges 확인--------------------");
		for (int i = 0; i < edges.size(); i++) {
			System.out.println(edges.get(i).v + " " + edges.get(i).w + " " + edges.get(i).c);
		}
		
		// 3. 크루스칼 알고리즘을 이용해 사이클이 없는 가장 짧은 경우를 찾는다.
		Collections.sort(edges, (e1, e2) -> e1.c - e2.c);
		
		parent = new int[c];
		
		makeSet();
		
		int cnt = 0; // cnt(다리의 수)가 c - 1개가 되면 종료한다.
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);
			
			if (union(edge.v, edge.w)) {
				cnt++;
				ans += edge.c;
			}
			
			if (cnt == c - 1) break;
		}
		
		if (cnt < c - 2) ans = -1;
		
		System.out.println(ans);
	}
	
	static int possible(int a, int b) {
		int ret = Integer.MAX_VALUE;
		
		List<Node> list1 = new ArrayList<>();
		List<Node> list2 = new ArrayList<>();
		
		// map을 순회하면서 번호가 a인 섬의 위치를 모두 list1에 번호가 b인 섬의 위치를 모두 list2에 Node형으로 저장한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == a) list1.add(new Node(i, j));
				else if (map[i][j] == b) list2.add(new Node(i, j));
			}
		}
		
		// 가로로 다리를 만들 수 있는지 확인한다.
		for (int i = 0; i < list1.size(); i++) {
			outer: for (int j = 0; j < list2.size(); j++) {
				// 가로로 다리를 만들 수 있는 경우
				if (list1.get(i).y == list2.get(j).y) {
					// 섬 사이에 다른 섬이 있으면 안된다.
					int start = Math.min(list1.get(i).x, list2.get(j).x);
					int end = Math.max(list1.get(i).x, list2.get(j).x);
					
					for (int k = start + 1; k < end; k++) {
						if (map[k][list1.get(i).y] != 0) continue outer;
					}
					if (Math.abs(list1.get(i).x - list2.get(j).x) - 1 >= 2) {
						ret = Math.min(ret, Math.abs(list1.get(i).x - list2.get(j).x) - 1);						
					}
				}
			}			
		}
				
		// 세로로 다리가 만들 수 있는지 확인한다.
		for (int i = 0; i < list1.size(); i++) {
			outer: for (int j = 0; j < list2.size(); j++) {
				// 세로로 다리를 만들 수 있는 경우
				if (list1.get(i).x == list2.get(j).x) {
					// 섬 사이에 다른 섬이 있으면 안된다.
					int start = Math.min(list1.get(i).y, list2.get(j).y);
					int end = Math.max(list1.get(i).y, list2.get(j).y);
					
					for (int k = start + 1; k < end; k++) {
						if (map[list1.get(i).x][k] != 0) continue outer;
					}
					
					if (Math.abs(list1.get(i).y - list2.get(j).y) - 1 >= 2) {
						ret = Math.min(ret, Math.abs(list1.get(i).y - list2.get(j).y) - 1);						
					}
				}
			}
		}
		
		// 다리가 안만들어지는 경우 -1을 리턴한다.
		if (ret == Integer.MAX_VALUE) return -1;
		
		return ret;
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == 2) {
			// complete code(섬 사이 다리 놓기)
			System.out.println(Arrays.toString(tgt));
			
			// 섬 두개가 다리를 놓을 수 있는지 확인해서 놓을 수 있다면 list에 저장
			int len = possible(tgt[0], tgt[1]);
			if (len >= 2) {
				Edge edge = new Edge(tgt[0], tgt[1], len);
				edges.add(edge);
			}
			
			return;
		}
		
		if (srcIdx == c - 1) return;
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
	
	static void dfs(int x, int y) {
		checked[x][y] = true;
		map[x][y] = c;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && !checked[nx][ny] && map[nx][ny] != 0) {
				dfs(nx, ny);
			}
		}
	}
	
	static void makeSet() {
		for (int i = 1; i <= c - 1; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if (px == py) return false;
		
		if (px < py) parent[py] = px;
		else parent[px] = py;
		
		return true;
	}
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
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
