package boj;

import java.util.Scanner;

public class BOJ_분수찾기_1193 {
	
	static int X;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		
		int cnt = 0;
		int child = 0;
		int parent = 2;
		int limit = 1;
		
		while (true) {			
			child++;
			parent--;
			cnt++;
			
			System.out.println(child + "/" + parent + " " + cnt);
						
			if (cnt == X) {
				System.out.println(child + "/" + parent);
				break;
			}
			
			if (child == limit) {
				child = 0;
				parent = limit + 2;
				limit++;
			}
		}
	}
}
