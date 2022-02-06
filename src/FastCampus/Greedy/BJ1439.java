package FastCampus.Greedy;

import java.util.*;

public class BJ1439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int[] cnt = new int[2];
		
		for(int i = 1; i < S.length(); i++) {
			if(S.charAt(i) != S.charAt(i-1))
				cnt[S.charAt(i)-'0']++;
		}
		
		System.out.println(Math.max(cnt[0], cnt[1]));
	}
}
