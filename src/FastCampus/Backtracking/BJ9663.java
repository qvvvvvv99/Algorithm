package FastCampus.Backtracking;

import java.io.*;

public class BJ9663 {
	static int col[];
	static int N;
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			col = new int[N + 1];
			col[1] = i;

			dfs(2);
		}
		
		System.out.println(ans);
	}

	public static void dfs(int row) {
		if (row > N)
			ans++;
		else {
			for (int i = 1; i <= N; i++) {
				col[row] = i;
				
				if (isPossible(row))
					dfs(row + 1);
				else
					col[row] = 0;
			}
		}
	}

	public static boolean isPossible(int c) {
		for (int i = 1; i < c; i++) {
			if (col[i] == col[c])
				return false;
			if (Math.abs(col[i] - col[c]) == c - i)
				return false;
		}
		return true;
	}
}
