package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	Bit Masking
public class SWEA_준환이의양팔저울_3234_2 {
	
	static int TC, N, ans;
//	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			N = Integer.parseInt(br.readLine());
			int[] choo = new int[N];
//			select = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			
			perm(0, 0, 0, 0, choo);
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	static void perm(int tgtIdx, int leftSum, int rightSum, int select, int[] choo) {
		//	기저 조건
		if (tgtIdx == N) {
			//	complete code
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((select & 1 << i) != 0) continue;
			
//			select[i] = true;
			//	2가지의 재귀호출
			//	#1 왼쪽에 추를 올리는 경우
			perm(tgtIdx + 1, leftSum + choo[i], rightSum, select | 1 << i, choo);
			//	#2 오르쪽에 추를 올리는 경우(문제의 조건 + 가지치기)
			if (leftSum >= rightSum + choo[i]) {
				perm(tgtIdx + 1, leftSum, rightSum + choo[i], select | 1 << i, choo);				
			}
//			select[i] = false;
		}
	}
}
