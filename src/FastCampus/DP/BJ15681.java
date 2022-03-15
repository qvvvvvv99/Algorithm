package FastCampus.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ15681 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N+1];
		LinkedList<Integer>[] tree = new LinkedList[N+1];
		int[] dp = new int[N+1];
		StringBuffer sb = new StringBuffer();
		
		for (int i = 1; i <= N; i++) {
            tree[i] = new LinkedList<Integer>();
        }
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}
		
		Arrays.fill(dp, 1);
		
		dfs(R, tree, visited, dp);
		
		for(int i = 0; i < Q; i++){
			int root = Integer.parseInt(br.readLine());
			sb.append(dp[root] + "\n");
		}
		
		System.out.print(sb);
	}
	
	public static int dfs(int v, LinkedList<Integer>[] tree, boolean[] visited, int[] dp) {
		visited[v] = true; // 정점 방문 표시

		Iterator<Integer> iter = tree[v].listIterator(); // 정점 인접리스트 순회
		while (iter.hasNext()) {
			int w = iter.next();
			if (!visited[w])
				dp[v] += dfs(w, tree, visited, dp); // 다시 DFS
		}
		return dp[v];
	}

}
