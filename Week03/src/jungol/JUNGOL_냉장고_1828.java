package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Fridge implements Comparable<Fridge> {
	int start;
	int end;
	
	public Fridge(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Fridge f) {
		if (this.end == f.end) {
			return this.start - f.start;
		} else {
			return this.end - f.end;
		}
	}
}

public class JUNGOL_냉장고_1828 {
	
	static int N, ans;
	static List<Fridge> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ans = 0;
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Fridge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		int start = -270;
		int end = -270;
		for (Fridge f : list) {
			if (f.start > end) {
				ans++;
				end = f.end;
			}
		}
		
		System.out.println(ans);
	}
}
