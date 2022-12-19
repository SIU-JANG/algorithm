package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_나무재태크_16235 {
	
	static int N, M, K;
	static int[][] map;
	static int[][] A;
	static List<Node> list = new ArrayList<>();
	static List<Node> deadTrees = new ArrayList<>();
	static PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> (n1.age - n2.age));
	
	// delta
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		A = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			list.add(new Node(x - 1, y - 1, age));
		}
		
		while (K-- > 0) {
			// 봄			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					pq.clear();
					for (int k = 0; k < list.size(); k++) {
						Node n = list.get(k);
						
						if (i == n.x && j == n.y) {
							pq.add(n);
						}
					}
					
					// 나이 어린 나무 순으로 양분을 먹는다.
					while (!pq.isEmpty()) {
						Node n = pq.peek();
						
						if (map[i][j] < n.age) {
							killTrees();
							break;
						}
						
						map[i][j] -= n.age;
						n.age++;
						pq.poll();
					}
				}
			}
			
			// 여름
			for (Node n : deadTrees) {
				map[n.x][n.y] += (n.age / 2);
			}
			
			deadTrees.clear();
			
			// 가을
			int currentSize = list.size();
			for (int i = 0; i < currentSize; i++) {
				Node n = list.get(i);
				if (n.age % 5 != 0) continue;
				
				for (int d = 0; d < 8; d++) {
					int nx = n.x + dx[d];
					int ny = n.y + dy[d];
					
					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						list.add(new Node(nx, ny, 1));
					}
				}
			}
			
			// 겨울
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] += A[i][j];
				}
			}
		}
		
		System.out.println(list.size());
	}
	
	static void killTrees() {
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			
			deadTrees.add(n);
			
			list.remove(n);
		}
	}
	
	static class Node {
		int x;
		int y;
		int age;
		
		public Node (int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Node) {
				Node n = (Node) obj;
				
				if (this.x == n.x && this.y == n.y && this.age == n.age) {
					return true;
				}
				
				return false;
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(x, y, age);
		}
	}
}
