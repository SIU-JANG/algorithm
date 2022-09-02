package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_연산자끼워넣기_14888 {
	
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] numbers;
	static int[] operations = new int[4];
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operations[i] = Integer.parseInt(st.nextToken());
		}
		
		// dfs를 이용하여 operations가 0보다 클 경우 하나씩 빼주면 계산
		dfs(numbers[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void dfs(int sum, int numIdx) {
		// 기저 조건
		if (numIdx == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (i == 0 && operations[i] > 0) {
				operations[i]--;
				dfs(sum + numbers[numIdx], numIdx + 1);
				operations[i]++;
			}
			
			if (i == 1 && operations[i] > 0) {
				operations[i]--;
				dfs(sum - numbers[numIdx], numIdx + 1);
				operations[i]++;
			}
			
			if (i == 2 && operations[i] > 0) {
				operations[i]--;
				dfs(sum * numbers[numIdx], numIdx + 1);
				operations[i]++;
			}
			
			if (i == 3 && operations[i] > 0) {
				operations[i]--;
				dfs(sum / numbers[numIdx], numIdx + 1);
				operations[i]++;
			}
		}
	}
}
