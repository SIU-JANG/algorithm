package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_색종이붙이기_17136 {
	
	static int ans, tAns;
	static int[][] map = new int[10][10];
	static int[][] prefixSum = new int[10][10];
	static boolean[][] checked;
	
	public static void main(String[] args) throws Exception {
		// Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// calculate prefix sum
		prefixSum[0][0] = map[0][0];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 0 && j == 0) continue;
				else if (i == 0 && j > 0) {
					prefixSum[i][j] = map[i][j] + prefixSum[i][j - 1];
				} else if (i > 0 && j == 0) {
					prefixSum[i][j] = map[i][j] + prefixSum[i - 1][j];
				} else {
					prefixSum[i][j] = map[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
				}
			}
		}
		
		// paper max size(5) setup
		int[] paper = new int[5];
		
		ans = Integer.MAX_VALUE;
		
		// 순서대로 순회
		for (int paperIndex = 4; paperIndex >= 0; paperIndex--) {
			Arrays.fill(paper, 5);
			tAns = 0;
			checked = new boolean[10][10];
			
			int paperIdx = paperIndex;
			int cnt = 5;
			while (cnt-- > 0) {
				for (int i = paperIdx; i < 10; i++) {
					boolean outOfPaper = false;
					for (int j = paperIdx; j < 10; j++) {
						if (paper[paperIdx] == 0) {
							outOfPaper = true;
							break;
						}
						if (i == paperIdx && j == paperIdx) {
							if (map[i][j] == 1 && prefixSum[i][j] == Math.pow(paperIdx + 1, 2) && !checked[i][j]) {
								paper[paperIdx] -= 1;
								// 조건이 맞으면 색종이를 채운다.
								fillPaper(i, j, paperIdx);
								tAns++;
							}
						} else if (i == paperIdx) {
							boolean flag = false;
							for (int a = i - paperIdx; a <= i; a++) {
								for (int b = j - paperIdx; b <= j; b++) {
									if (checked[a][b]) {
										flag = true;
										break;
									}
								}
								
								if (flag) {
									break;
								}
							}
							if (map[i][j] == 1 && prefixSum[i][j] - prefixSum[i][j - paperIdx - 1] == Math.pow(paperIdx + 1,  2) && !flag) {
								paper[paperIdx] -= 1;
								fillPaper(i, j, paperIdx);
								tAns++;
							}
						} else if (j == paperIdx) {
							boolean flag = false;
							for (int a = i - paperIdx; a <= i; a++) {
								for (int b = j - paperIdx; b <= j; b++) {
									if (checked[a][b]) {
										flag = true;
										break;
									}
								}
								
								if (flag) {
									break;
								}
							}
							if (map[i][j] == 1 && prefixSum[i][j] - prefixSum[i - paperIdx - 1][j] == Math.pow(paperIdx + 1,  2) && !flag) {
								paper[paperIdx] -= 1;
								fillPaper(i, j, paperIdx);
								tAns++;
							}
						} else {
							boolean flag = false;
							for (int a = i - paperIdx; a <= i; a++) {
								for (int b = j - paperIdx; b <= j; b++) {
									if (checked[a][b]) {
										flag = true;
										break;
									}
								}
								
								if (flag) {
									break;
								}
							}
							if (map[i][j] == 1 && prefixSum[i][j] - prefixSum[i - paperIdx - 1][j] - prefixSum[i][j - paperIdx - 1] + prefixSum[i - paperIdx - 1][j - paperIdx - 1] == Math.pow(paperIdx + 1,  2) && !flag) {
								paper[paperIdx] -= 1;
								fillPaper(i, j, paperIdx);
								tAns++;
							}
						}
					}
					if (outOfPaper) {
						break;
					}
				}
				
				if (paperIdx == 0) {
					paperIdx = 4;
				} else {
					paperIdx--;
				}
			}
			
			boolean correct = true;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (map[i][j] == 1 && !checked[i][j]) {
						correct = false;
						break;
					}
				}
				
				if (!correct) {
					break;
				}
			}
			
			if (correct) {
				ans = Math.min(ans, tAns);
			}
		}
		
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		
		System.out.println(ans);
		
	}
	
	static void fillPaper(int i, int j, int paperSize) {
		for (int k = i - paperSize; k <= i; k++) {
			for (int l = j - paperSize; l <= j; l++) {
				checked[k][l] = true;
			}
		}
	}
}
