package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_야구_17281 {
	
	static int N, ans;
	static int[][] players;
	static int[] src = new int[9];
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		players = new int[N][9];
		for (int i = 0; i < 9; i++) src[i] = i;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				players[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			if (src[3] == 4) check();
			
			if (!np()) {
				break;
			}
		}
		
		System.out.println(ans);
	}
	
	static void check() {
		//	점수
		int score = 0;
		//	루에 있는 주자를 기록하는 큐
		Deque<Integer> dq = new ArrayDeque<>();
		//	출전 선수 순번
		int idx = 0;
		//	이닝 반복
		for (int i = 0; i < N; i++) {
			//	아웃 카운트 => 3이 되면 다음 이닝
			int outCount = 0;
			dq.clear();
			while (outCount < 3) {
				while (dq.size() < 3) {
					dq.addFirst(0);
				}
				
				dq.addFirst(1);
				int behavior = players[i][src[idx++]];
				System.out.println(behavior);
				if (idx >= 9) idx = 0;
				switch (behavior) {
					case 1:
						if (dq.removeLast() == 1) score++;
						break;
					case 2:
						if (dq.removeLast() == 1) score++;
						if (dq.removeLast() == 1) score++;
						break;
					case 3:
						if (dq.removeLast() == 1) score++;
						if (dq.removeLast() == 1) score++;
						if (dq.removeLast() == 1) score++;
						break;
					case 4:
						if (dq.removeLast() == 1) score++;
						if (dq.removeLast() == 1) score++;
						if (dq.removeLast() == 1) score++;
						if (dq.removeLast() == 1) score++;
						break;
					case 5:
						outCount++;
						dq.removeFirst();
						break;
				}
			}
		}
		
		ans = Math.max(ans, score);
	}
	
	static boolean np() {
		int i = src.length - 1;
		while (i > 0 && src[i - 1] >= src[i]) --i;
		
		if (i == 0) return false;
		
		int j = src.length - 1;
		while (src[i - 1] >= src[j]) --j;
		
		swap(i - 1, j);
		
		int k = src.length - 1;
		while (i < k) swap(i++, k--);
		
		return true;
	}
	
	static void swap(int i, int j) {
		int temp = src[i];
		src[i] = src[j];
		src[j] = temp;
	}
}
