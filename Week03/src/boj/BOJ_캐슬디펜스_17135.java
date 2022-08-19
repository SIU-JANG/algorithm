package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Target {
	int x;
	int y;
	
	public Target(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_캐슬디펜스_17135 {
	
	static int N, M, D;
	static int[][] map;
	static int[] src;
	static int[] tgt = new int[3];
	static List<Target> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		//	입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		src = new int[N];
		for (int i = 0; i < N; i++) {
			src[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//	궁수 배치(조합)
		comb(0, 0);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == 3) {
			// 궁수 배치 완료 시 시뮬레이션 시작
			simulate();
			return;
		}
		
		if (srcIdx == src.length) {
			return;
		}
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
	
	static void simulate() {
		//	1. 각 궁수가 사정 거리 안에 있는 적에게 1번 공격
		
		//	2. 적이 모두 1칸씩 아래로 이동
	}
}