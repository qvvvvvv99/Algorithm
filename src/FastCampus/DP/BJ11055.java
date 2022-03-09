package FastCampus.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11055 {
	static int[] ary;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ary = new int[n];
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int[] dp = new int[n];

		for (int i = 0; i < n; i++)
			ary[i] = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++)
			dp[i] = ary[i];
		searchMax(dp, n);

		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}

	public static void searchMax(int[] dp, int n) {
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (ary[i] > ary[j]) {
					dp[i] = Math.max(ary[i] + dp[j], dp[i]);
				}
			}
		}
	}

}
