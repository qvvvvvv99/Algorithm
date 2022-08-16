package AlgoStudy.Week5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ20437 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 데이터 추가/삭제가 ArrayList 보다 빠르다.
		LinkedList<Integer>[] alphaList = new LinkedList[26];
		for(int i = 0; i < 26; i++)
			alphaList[i] = new LinkedList<Integer>();
		int[] alphaCnt = new int[26];
		StringBuffer sb = new StringBuffer();
		
		for(int tc = 0; tc < T; tc++) {
			for(int i = 0; i < 26; i++)
				alphaList[i].clear();
			Arrays.fill(alphaCnt, 0);
			
			String W = sc.next();
			int K = sc.nextInt();
			int max = 0, min = W.length();
			for(int i = 0; i < W.length(); i++) {
				alphaCnt[W.charAt(i)-'a']++;
				alphaList[W.charAt(i)-'a'].add(i);
				if(alphaCnt[W.charAt(i)-'a'] == K) {
					int len = i - alphaList[W.charAt(i)-'a'].poll() + 1;
					alphaCnt[W.charAt(i)-'a']--;
					min = Math.min(min, len);
					max = Math.max(max, len);
				}
			}
			if(max == 0)
				sb.append(-1+"\n");
			else
				sb.append(min + " " + max + "\n");
		}
		
		System.out.print(sb);
	}

}
