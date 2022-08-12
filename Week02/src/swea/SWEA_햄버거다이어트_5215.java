package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_햄버거다이어트_5215 {
	
	static int T, cnt, max, ans;
	static int[] score, cal;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			max = Integer.parseInt(st.nextToken());
			
			cal = new int[cnt];
			score = new int[cnt];
			ans = 0;
			
			for (int i = 0; i < cnt; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			selectHamburger(0, 0, 0);
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	static void selectHamburger(int tgtIdx, int scoreSum, int calSum) {
		if (calSum > max) {
			return;
		}
		
		if (tgtIdx == cnt) {
			ans = scoreSum > ans ? scoreSum : ans;
			return;
		}
		
		selectHamburger(tgtIdx + 1, scoreSum + score[tgtIdx], calSum + cal[tgtIdx]);
		selectHamburger(tgtIdx + 1, scoreSum, calSum);
	}
}
