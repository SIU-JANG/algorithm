package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_헌터_15172 {
	
	static int TC, N, srcSize, sx, sy, ans;
	static int[][] map;
	static int[] src;
	static boolean[] checked;
	
	static List<Node> list;
	
	public static void main(String[] args) throws Exception {
		//	입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			ans = Integer.MAX_VALUE;
			srcSize = 0;
			list = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) {
						srcSize++;
						list.add(new Node(i, j, map[i][j]));
					} 
				}
			}			
			
			src = new int[srcSize];
			for (int i = 0; i < srcSize; i++) {
				src[i] = i;
			}
			
			//	np를 이용해 완전탐색
			while (true) {
				sx = sy = 0;
				checked = new boolean[(srcSize / 2) + 1];
				check();
				
				if (!np()) break;
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	static void check() {
		int sum = 0;
		
		for (int i = 0; i < srcSize; i++) {
			Node next = list.get(src[i]);
			// 몬스터인 경우 -> 헌터가 잡으러 간다.
			if (next.c > 0) {
				sum += Math.abs(next.x - sx) + Math.abs(next.y - sy);
				// 헌터의 위치 갱신
				sx = next.x;
				sy = next.y;
				// 몬스터 잡은 것 기록
				checked[next.c] = true; 
			} else {
				// 고객인 경우 -> 몬스터가 잡혀 있을 때만 방문 가능(check 사용)
				// 몬스터가 안잡힌 경우는 return
				if (!checked[-next.c]) return;
				
				sum += Math.abs(next.x - sx) + Math.abs(next.y - sy);
				// 헌터의 위치 갱신
				sx = next.x;
				sy = next.y;
			}
		}
		
		ans = Math.min(sum, ans);
	}
	
	static class Node {
		int x;
		int y;
		int c;
		
		public Node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	
	static boolean np() {
		int i = srcSize - 1;
		while (i > 0 && src[i - 1] >= src[i]) --i;
		
		if (i == 0) return false;
		
		int j = srcSize - 1;
		while (src[i - 1] >= src[j]) --j;
		swap(i - 1, j);
		
		int k = srcSize - 1;
		while (i < k) swap(i++, k--);
		
		return true;
	}
	
	static void swap(int i, int j) {
		int temp = src[i];
		src[i] = src[j];
		src[j] = temp;
	}
}
