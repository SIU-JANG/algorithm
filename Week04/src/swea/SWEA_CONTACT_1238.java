package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_CONTACT_1238 {
	
	static int N, start, from, to, ans, test_case = 1;;
	static int[][] map;
	static boolean[] checked;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws Exception {
		//	입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String s = br.readLine();
			if (s == null) break;
			
			StringTokenizer st = new StringTokenizer(s);
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			map = new int[101][101];
			checked = new boolean[101];
			q = new ArrayDeque<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
				map[from][to] = 1;
				map[to][from] = 1;
			}
			
			//	bfs
			bfs();
			
			System.out.println("#" + test_case++ + " " + ans);
		}
	}
	
	static void bfs() {
		q.add(start);
		checked[start] = true;
		
		while (!q.isEmpty()) {
			int currentSize = q.size();
			for (int i = 0; i < currentSize; i++) {
				int cur = q.poll();
				for (int j = 1; j < 101; j++) {
					if (!checked[j] && map[cur][j] == 1) {
						q.add(j);
						System.out.println(j);
						checked[j] = true;
						ans = j;
					}
				}
			}
		}
	}
}
