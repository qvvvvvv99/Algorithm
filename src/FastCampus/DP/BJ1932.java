package FastCampus.DP;

import java.io.*;
import java.util.*;

public class BJ1932 {
	static int n;
	static int[][] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new int[n][n];
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for (int j = 0; j <= i; j++) {
				tree[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = tree[0][0];
		searchMax(dp);
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(max < dp[n-1][i])
				max = dp[n-1][i];
		}
		System.out.println(max);
	}

	public static void searchMax(int[][] dp) {
		for (int lev = 1; lev < n; lev++) {
			for (int i = 0; i <= lev; i++) {
				int max = 0;
				for (int j = -1; j < 1; j++) {
					if (i + j < 0 || i + j > lev - 1)
						continue;
					if (max < dp[lev - 1][i + j])
						max = dp[lev - 1][i + j];
				}
				dp[lev][i] = tree[lev][i] + max;
			}
		}
	}

}
