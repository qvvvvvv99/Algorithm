package AlgoStudy.M2_W2;

import java.util.Scanner;

public class BJ12919 {
	static int cnt;
	static String str1;
	static boolean flag = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		str1 = sc.next();
		String str2 = sc.next();

		StringBuffer sb2 = new StringBuffer(str2);
		cnt = sb2.length() - str1.length();

		sol(sb2, 0);
		
		if(flag)
			System.out.println(1);
		else
			System.out.println(0);
	}
	
	static void sol(StringBuffer sb, int n) {
		if(n == cnt) {
			if(sb.toString().equals(str1))
				flag = true;
			return;
		}
		
		if(sb.charAt(sb.length()-1) == 'A') {
			sb = sb.delete(sb.length()-1, sb.length());
			n++;
			sol(sb, n);
			n--;
			sb.append('A');
		}
		if(sb.charAt(0) == 'B') {
			sb = sb.delete(0, 1);
			sb = sb.reverse();
			n++;
			sol(sb, n);
			n--;
			sb = sb.reverse();
			sb.insert(0, 'B');
		}
		if(flag)
			return;
	}
}
