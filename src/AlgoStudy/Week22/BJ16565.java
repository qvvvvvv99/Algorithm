package AlgoStudy.Week22;

import java.util.Scanner;

public class BJ16565 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[53][53];

		dp[0][0] = 1;
		for (int i = 1; i <= 52; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
			for (int j = 1; j <= i; j++)
				dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % 10007;
		}
		
		int res = 0;
		for(int i = 4; i <= N; i+=4) {
			if((i/4) % 2 == 1)
				res += (dp[13][i/4] * dp[52-i][N-i]);
			else
				res -= (dp[13][i/4] * dp[52-i][N-i]);
			res %= 10007;
		}

		if(res < 0)
			res += 10007;
		System.out.println(res);
		
	}
}
