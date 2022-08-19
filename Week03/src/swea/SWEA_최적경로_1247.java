package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Customer {
	int x;
	int y;
	
	public Customer(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SWEA_최적경로_1247 {
	
	static int TC, N, ans;
	static int companyX, companyY, homeX, homeY;
	static List<Customer> list = new ArrayList<>();
	static boolean[][] checked;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int startX = 0;
			int startY = 0;
			
			list.clear();
			for (int i = 0; i < N + 2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if (i == 0) {
					companyX = x;
					companyY = y;
				} else if (i == 1) {
					homeX = x;
					homeY = y;
				} else {
					list.add(new Customer(x, y));
				}
			}
			
			checked = new boolean[101][101];
			ans = Integer.MAX_VALUE;
			dfs(companyX, companyY, 0, 0);
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	static void dfs(int x, int y, int dist, int cnt) {
		checked[x][y] = true;
		if (cnt == list.size()) {
			ans = Math.min(ans, dist + getDistance(x, y, homeX, homeY));			
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (!checked[list.get(i).x][list.get(i).y]) {
				dfs(list.get(i).x, list.get(i).y, dist + getDistance(x, y, list.get(i).x, list.get(i).y), cnt + 1);				
			}
		}
		
		checked[x][y] = false;
		return;
	}
	
	static int getDistance(int x1, int y1, int x2, int y2) {
		return (Math.abs(x1 - x2) + Math.abs(y1 - y2));
	}
}
