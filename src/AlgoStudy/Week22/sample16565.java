package AlgoStudy.Week22;

import java.util.Scanner;

public class sample16565 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();

		for (int N = 1; N <= 52; N++) {
			int[][] comb = new int[53][53];
			int MOD = 10007;

			for (int i = 0; i <= 52; i++)
				comb[i][0] = 1;
			for (int i = 1; i <= 52; i++)
				for (int j = 1; j <= 52; j++)
					comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;

			int ans = 0;
			for (int i = 1; i <= 13 && N - 4 * i >= 0; i++) {
				if (i % 2 == 1)
					ans = (ans + comb[52 - 4 * i][N - 4 * i] * comb[13][i]) % MOD;
				else
					ans = (ans - (comb[52 - 4 * i][N - 4 * i] * comb[13][i]) % MOD + MOD) % MOD;
			}
			System.out.println(ans);
		}

	}
}
