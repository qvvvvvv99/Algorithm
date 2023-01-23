package Softeer;

import java.util.Scanner;

public class HDM3 {
	static int MOD = 1000000007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int len = input.length();
		// input까지 수 중 13이 존재하지 않는 수의 갯수
		
		int[] num = new int[len];
		for(int i = 0; i < len; i++)
			num[i] = input.charAt(i)-'0';
		

		int[][] dp = new int[len + 1][10];
		// dp[i][j] -> i 자리수의 가장 앞 자리가 j 일때 안전한 수
		// dp[i][0] = dp[i-1][0~9]
		// j가 1보다 큰 경우 : dp[i][j] = dp[i][0]
		// j가 1인 경우 = dp[i-1][0,1,2,4~9]
		// i == len이고 input의 앞자리가 j일 경우
		for (int i = 0; i < 10; i++)
			dp[1][i] = 1;
		
		for (int i = 2; i < len; i++) {
			// 앞자리 0인 경우
			for (int j = 0; j < 10; j++)
				dp[i][0] += dp[i-1][j] % MOD;
			
			// 앞자리 1인 경우
			for (int j = 0; j < 10; j++) {
				if(j == 3)
					continue;
				dp[i][1] += dp[i-1][j] % MOD;
			}
			
			// 앞자리 1보다 큰 경우
			for(int j = 2; j < 10; j++)
				dp[i][j] = dp[i][0];
		}
		
		int left = num[0];
		// input 길이 배열
		// 앞자리 0
		for (int j = 0; j < 10; j++)
			dp[len][0] += dp[len-1][j] % MOD;
		// 앞자리 1
		for (int j = 0; j < 10; j++) {
			if(j == 3)
				continue;
			dp[len][1] += dp[len-1][j] % MOD;
		}
		// input의 앞지리 수 전까지
		for (int j = 2; j < left; j++) 
			dp[len][j] = dp[len][0];
		
		// input의 앞자리와 같은 경우
		int res = 0;
		int curr, l = len;
		for(int idx = 0; idx <= len; idx++) {	// idx 번째 숫자를 보고 있다
			if(idx >= 2 && num[idx-2] == 1 && num[idx-1] == 3)
				break;
			if(idx == len) {
				res++;
				break;
			}
			curr = num[idx];
			for(int j = 0; j < curr; j++) {
				if(j == 3 && idx >= 1 && num[idx-1] == 1)
					continue;
				res += dp[l][j] % MOD;
			}
			l--;
		}

		System.out.println((res+MOD-1)%MOD);
	}

}
