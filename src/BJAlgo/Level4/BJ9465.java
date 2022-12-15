package BJAlgo.Level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] ary = new int[2][n];
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) 
					ary[i][j] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(solve(n, ary)).append("\n");
		}
		System.out.print(sb);
	}

	static int solve(int n, int[][] ary) {
		int[][] dp = new int[2][n+1];
		dp[0][1] = ary[0][0];
		dp[1][1] = ary[1][0];
		
		for(int i = 2; i <= n; i++) {
			dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + ary[0][i-1];
			dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + ary[1][i-1];
		}
		
		return Math.max(dp[0][n], dp[1][n]);
	}
}
