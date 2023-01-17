package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_집합_11723 {
	
	static int N, n;
	static String command;
	
	// bitmask
	static boolean[] bitmask = new boolean[(1 << 19) + 1];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if (!command.equals("all") && !command.equals("empty")) {
				n = Integer.parseInt(st.nextToken());				
			}
			
			// add
			switch(command) {
			case "add":
				bitmask[1 << (n - 1)] |= true;
				break;
			case "remove":
				bitmask[1 << (n - 1)] &= false;
				break;
			case "check":
				if (bitmask[1 << (n - 1)]) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "toggle":
				bitmask[1 << (n - 1)] ^= true;
				break;
			case "all":
				for (int j = 1; j <= 20; j++) {
					bitmask[1 << (j - 1)] |= true;
				}
				break;
			case "empty":
				for (int j = 1; j <= 20; j++) {
					bitmask[1 << (j - 1)] &= false;
				}
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}