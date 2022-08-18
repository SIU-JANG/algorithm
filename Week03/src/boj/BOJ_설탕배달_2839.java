package boj;

import java.util.Arrays;
import java.util.Scanner;

//DP => Memoization + 점화식
	//	int[] memoi <= 문제를 풀어나가는 과정에서 갱신( 케바케 상황에 따라 갱신 )
	//	int[] dp <= 초기값 (점화식 0일때, 1일때 ...) dp[0] = ? dp[1] = ?
	//	=> dp 에 점화식을 적용, 초기값이 존재하므로, 초기값 이후의 값은 점화식을 반복적용하면서 채워나간다.
	//	문제가 N 일 때 얼마?? 0 또는 1 등 부터 쭉 N 까지 채워 나가면 끝난다.
	//	DP 문제의 특징
	//	1. 코드가 간결하다.
	//	2. 매우 안정적(실수가 거의 없는)
	//	3. 정말 빠르다.
	
	// 문제가 있다면?? 점화식을 만들어내는 것이 매우 어렵다.
public class BOJ_설탕배달_2839 {
	
	static int N;
	static int[] dp; // 어떤 값을 만드는 데 필요한 봉투의 수 // dp[X] = Y 의미는 X 무게를 만드는 데 Y 만큼의 봉투를 사용한다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		if (N <= 5) {
			if (N == 3 || N == 5) System.out.println(1);
			else System.out.println(-1);
			return;
		}
		// 6 이상
		dp = new int[N + 1];
		// 보정
		Arrays.fill(dp, 5000);// 충분히 큰 수로 채운다.
		
		// 초기 인덱스의 값 ( 점화식 적용 전 )
		dp[3] = 1;
		dp[5] = 1;
		
		for (int i = 6; i <= N; i++) {
			// 점화식 - 최소값을 이용
			dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
		}
		//	초기 인덱스의 값( 점화식 적용 전 )
		//	1, 2, 3, 4, 5
		
		if (dp[N] > 5000) {
			dp[N] = -1;
		}
		System.out.println(dp[N]);
	}
}
