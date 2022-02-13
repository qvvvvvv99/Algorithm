package FastCampus.Backtracking;

// BJ 15656 N�� M (7)

import java.io.*;
import java.util.*;

public class NM_7 {
	static int N;
	static int M;
	static int[] ans;
	static int[] list;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new int[N];
		ans = new int[M];
		
		input = br.readLine();
		st = new StringTokenizer(input);
		for(int i = 0; i < N; i++)
			list[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(list);

		dfs(0);

		System.out.println(sb);
	}

	public static void dfs(int idx) {
		if(idx >= M) {	
			for(int i = 0; i < M; i++)
				sb.append(ans[i] + " ");
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			ans[idx] = list[i];
			dfs(idx+1);
		}
	}

}