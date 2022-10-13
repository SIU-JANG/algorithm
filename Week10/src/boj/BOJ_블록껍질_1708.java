package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_블록껍질_1708 {
	
	static int N;
	static long sx, sy;
	static long[][] point;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		point = new long[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
			
			if (i == 0) {
				sx = point[i][0];
				sy = point[i][1];
			} else {
				if (sy > point[i][1]) {
					sx = point[i][0];
					sy = point[i][1];
				} else if (sy == point[i][1]) {
					if (sx > point[i][0]) {
						sx = point[i][0];
						sy = point[i][1];
					}
				}
			}
		}
		
		// 시작점 sx, sy 지정 ( 맨 앞의 점을 시작점으로 )
		// 시작점을 y 가 가장 작은 점, y 가 같은 점이 있다면 x 가 가장 작은 점
		
		// point 배열을 반시계방향으로 정렬
		Arrays.sort(point, (p1, p2) -> {
			int ret = ccw(sx, sy, p1[0], p1[1], p2[0], p2[1]);
			if (ret > 0) { // 반시계방향
				return -1;
			} else if (ret < 0) { // 시계방향
				return 1;
			} else {
				long diff = distance(sx, sy, p1[0], p1[1]) - distance(sx, sy, p2[0], p2[1]);
				return diff > 0 ? 1 : -1;
			}
		});
				
		// stack 객체 생성
		Stack<Node> s = new Stack<>();
		// 시작점을 Stack 에 넣는다.
		Node n = new Node(sx, sy);
		s.add(n);
		
		// 시작점을 제외한 모든 점을 순회
		for (int i = 1; i < N; i++) {
			Node next = new Node(point[i][0], point[i][1]);
			
			if (s.size() < 2) s.add(next);
			else {
				while (true) {
					if (s.size() < 2) {
						s.add(next);
						break;
					}
					
					Node prev1 = s.pop();
					Node prev2 = s.peek();
					
					if (ccw(prev2.x, prev2.y, prev1.x, prev1.y, point[i][0], point[i][1]) == 1) {
						s.add(prev1);
						s.add(next);
						break;
					}
				}
			}
		}
		
		// for 문을 이용해서 각 i 점에 대해서
		// stack 에 들어가 있는 이전 2개의 점과 i 점과의 ccw를 확인해서 
		// 반시계방향이 아니면 계속 꺼낸다.(반복적으로) => stack 에 i 점을 넣는다.
		
		// stack 에 들어가 있는 점들이 바로 볼록껍질을 구성하는 점들이므로 Stack 의 크기를 출력
		System.out.println(s.size());
	}
	
	static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		int ret = 0;
		// ret 는 양수 음수 여부를 따져서 반시계방향 (1), 시계방향 (-1) 여부를 리턴, 같으면 (0)
		
		long ccwVal = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
		
		if (ccwVal < 0) ret = -1;
		else if (ccwVal > 0) ret = 1;
		else ret = 0;
		
		return ret;
	}
	
	static long distance(long x1, long y1, long x2, long y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	static class Node {
		long x;
		long y;
		
		public Node(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}
