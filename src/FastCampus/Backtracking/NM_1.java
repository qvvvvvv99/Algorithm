package FastCampus.Backtracking;

// BJ 15649번 N과 M (1)
// 백트래킹(완전탐색)

import java.io.*;
import java.util.*;

public class NM_1 {
	static int N;
	static int M;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = new int[M];
		
		dfs(0);
	}
	
	public static void dfs(int idx) {
		if(idx >= M) {
			for(int i = 0; i < M; i++)
				System.out.print(ans[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			ans[idx] = i;
			if(check(idx))
				dfs(idx+1);
		}
	}
	
	public static boolean check(int idx) {
		for(int i = 0; i < idx; i++) {
			if(ans[i] == ans[idx])
				return false;
		}
		return true;
	}

}
