package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_잃어버린괄호_1541 {
	
	static String str;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		
		String[] tempArr = str.split("-");
		
		for (int i = 0; i < tempArr.length; i++) {
			String[] tempArr2 = tempArr[i].split("\\+");
			int sum = 0;
			for (int j = 0; j < tempArr2.length; j++) {
				sum += Integer.parseInt(tempArr2[j]);
			}
			list.add(sum);
		}
		
		int ans = list.get(0);
		if (list.size() == 1) {
			System.out.println(ans);
		} else {
			for (int i = 1; i < list.size(); i++) {
				ans -= list.get(i);
			}
			
			System.out.println(ans);
		}
	}
}
