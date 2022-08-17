package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Z_1074_recursive {
	
	static int N, r, c, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		//	N 은 2의 제곱수이므로 N을 실제 좌, 우에 해당하는 길이로 보정
		N = (int) Math.pow(2, N);	// N 은 2로 나눌 수 있다.
		
		//	분할정복
		recursive(N);
		
		System.out.println(ans);
	}
	
	static void recursive(int N) {
		if (N == 1) {
			return;
		}
		
		if (r < N / 2 && c < N / 2) {
			ans += (N * N / 4) * 0;
			recursive(N / 2);
		} else if (r < N / 2 && c >= N / 2) {
			ans += (N * N / 4) * 1;
			c += N / 2;
			recursive(N / 2);
		} else if (r >= N / 2 && c < N / 2) {
			ans += (N * N / 4) * 2;
			r += N / 2;
			recursive(N / 2);
		} else if (r >= N / 2 && c >= N / 2) {
			ans += (N * N / 4) * 3;
			r += N / 2;
			c += N / 2;
			recursive(N / 2);
		}
	}
}
