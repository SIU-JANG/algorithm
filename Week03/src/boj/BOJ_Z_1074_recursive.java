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
		z(0, 0);
		
		System.out.println(ans);
	}
	
	static void z(int y, int x) {
		// 기저 조건
		if (N == 1) return;
		
		//		가로, 세로를 반으로 나누어서 4 공간으로 분할
		N /= 2;
				
		//	r, c 가 4 공간 중 어느 곳에 해당하는 지 판단, 각 공간에서 r, c, 값에 따라 ans 값 갱신, 원점 보정
		if (r < y + N && c < x + N) {	// top-left
			z(y, x);
		} else if (r < y + N && c >= x + N) {	// top-right
			ans += (N * N * 1);
			z(y, x + N);
		} else if (r >= y + N && c <x + N) {	// top-right
			ans += (N * N * 2);
			z(y + N, x);
		} else {	// top-right
			ans += (N * N * 3);
			z(y + N, x + N);
		}
	}
}
