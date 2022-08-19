package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_알파벳_1987 {
	
	static int R, C, ans;
	static String[] alphabet;
	
	//	중복 체크
	static Set<Character> set = new HashSet<>();
	
	//	delta
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	
	public static void main(String[] args) throws Exception {
		//	입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new String[R];
		
		for (int i = 0; i < R; i++) {
			alphabet[i] = br.readLine();
		}
		
		set.add(alphabet[0].charAt(0));
		dfs(0, 0, 1);
		
		System.out.println(ans);
	}
	
	static void dfs(int x, int y, int cnt) {		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (nx >= 0 && nx < R && ny >= 0 && ny < C && !set.contains(alphabet[nx].charAt(ny))) {
				set.add(alphabet[nx].charAt(ny));
				dfs(nx, ny, cnt + 1);
			}
		}
		
		set.remove(alphabet[x].charAt(y));
		
		ans = Math.max(ans, cnt);
		return;
	}
}
