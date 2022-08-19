package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_준환이의양팔저울_3234_3 {
	
	static int TC, N, ans;
//	static int[] choo;
//	static boolean[] select;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			N = Integer.parseInt(br.readLine());
			int[] choo = new int[N];
			boolean[] select = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			
			perm(choo, select, 0, 0, 0);
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	static void perm(int[] choo, boolean[] select, int tgtIdx, int leftSum, int rightSum) {
		if (rightSum > leftSum) {
			return;
		}
		//	기저 조건
		if (tgtIdx == N) {
			//	complete code
			ans++;
			return;
		}
		
		for (int i = 0; i < choo.length; i++) {
			if (select[i]) continue;
			
			select[i] = true;
			//	2가지의 재귀호출
			//	#1 왼쪽에 추를 올리는 경우
			perm(choo, select, tgtIdx + 1, leftSum + choo[i], rightSum);
			//	#2 오르쪽에 추를 올리는 경우(문제의 조건 + 가지치기)
			perm(choo, select, tgtIdx + 1, leftSum, rightSum + choo[i]);
			select[i] = false;
		}
	}
}
