package FastCampus.DP;

// BJ 9251번 LCS
// LCS(Longest Common Subsequence, 최장 공통 부분 수열)
// 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는다

import java.util.*;

public class BJ9251 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int row = str1.length();
		int col = str2.length();
		
		int[][] ary = new int[row+1][col+1];
		
		for(int i = 1; i <= row; i++) {
			for(int j = 1; j <= col; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) 
					ary[i][j] = ary[i-1][j-1] + 1;
				else
					ary[i][j] = Math.max(ary[i-1][j], ary[i][j-1]);
			}
		}
		System.out.println(ary[row][col]);
	}

}
