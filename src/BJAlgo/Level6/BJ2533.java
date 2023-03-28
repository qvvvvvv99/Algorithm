package BJAlgo.Level6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2533 {
	static int N;
	static ArrayList<Integer>[] tree;
	static int [][] dp;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<>();

		int u, v;
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}

		visited = new boolean[N+1];
		dp = new int[N+1][2];
		dfs(1);

		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	static void dfs(int n) {
		visited[n] = true;
		dp[n][0] = 0;
		dp[n][1] = 1;
		
		for(int child : tree[n]) {
			if(!visited[child]) {
				dfs(child);
				dp[n][0] += dp[child][1];
				dp[n][1] += Math.min(dp[child][0], dp[child][1]);
			}
		}
	}
}