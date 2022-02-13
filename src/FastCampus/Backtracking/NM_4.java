package FastCampus.Backtracking;

// BJ 15652 N�� M (4)

import java.io.*;
import java.util.*;

public class NM_4 {
	static int N;
	static int M;
	static int[] ans;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = new int[M];

		dfs(0);

		System.out.println(sb);
	}

	public static void dfs(int idx) {
		if (idx >= M) {
			for (int i = 0; i < M; i++)
				sb.append(ans[i] + " ");
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			ans[idx] = i;
			if (check(idx))
				dfs(idx + 1);
		}
	}

	public static boolean check(int idx) {
		if (idx > 0) {
			if (ans[idx] < ans[idx - 1])
				return false;
		}
		return true;
	}

}