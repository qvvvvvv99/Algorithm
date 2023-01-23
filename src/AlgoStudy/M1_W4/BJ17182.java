package AlgoStudy.M1_W4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17182 {
	static int N, K, min = 10001;
	static boolean[] visited;
	static int[][] res;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] T = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				T[i][j] = Integer.parseInt(st.nextToken());
		}
		
		res = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				res[i][j] = T[i][j];
		}
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(res[i][j] > T[i][k] + T[k][j])
						res[i][j] = T[i][k] + T[k][j];
				}
			}
		}
		
		visited = new boolean[N];
		visited[K] = true;
		dfs(K, 1, 0);
		
		System.out.println(min);
	}

	static void dfs(int idx, int cnt, int sum) {
		if(cnt == N) {
			min = Math.min(sum, min);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i])
				continue;
			sum += res[idx][i];
			visited[i] = true;
			cnt++;
			dfs(i, cnt, sum);
			cnt--;
			visited[i] = false;
			sum -= res[idx][i];
		}
	}
}
