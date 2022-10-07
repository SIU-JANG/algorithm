package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// memoi 배열에 pos (memoi 의 index) 길이를 채우는 가장 작은 입력값 (input[..])을 넣는다.
// memoi[4] = 7 : LIS 길이가 4인 부분수열을 만드는 데 가장 작은 값이 (현재) 7 이다.

// memoi[1] = 3
// memoi[2] = 5
// memoi[3] = 6
// memoi[4] = 7
// input 의 다음 고려수 2 -> memoi[1] = 2로 바꾼다.(Binary Search) 
public class SWEA_최종증가부분수열_3307 {
	
	static int T, N, len;
	static int[] input;
	static int[] memoi; // LIS X // 부분수열의 길이별 가장 작은 값(입력) 저장
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			input = new int[N]; // index => for 문 i
			memoi = new int[N]; // pos 별도의 index 로 관리
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			// LIS 의 len 을 구한다.
			len = 0;
			for (int i = 0; i < N; i++) {
				
				int pos = Arrays.binarySearch(memoi, 0, len, input[i]);
				if (pos >= 0) continue;
				pos = Math.abs(pos) - 1;
				memoi[pos] = input[i]; // 항상 마지막 위치만 더하는 것이 아니라 중간 값도 갱신이 일어날 수 있다.
				
				if (len == pos) len++;
			}
			
			System.out.println("#" + t + " " + len);
		}
	}
}
