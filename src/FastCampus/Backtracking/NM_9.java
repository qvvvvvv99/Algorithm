package FastCampus.Backtracking;

import java.io.*;
import java.util.*;

public class NM_9 {
	static int N;
	static int M;
	static int[] ans;
	static int[] list;
	static StringBuffer sb = new StringBuffer();
	static HashSet<StringBuffer> set = new HashSet<>();

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

		Iterator iter = set.iterator();
		while(iter.hasNext())
			System.out.println(iter.next() + "\n");
	}

	public static void dfs(int idx) {
		if(idx >= M) {	
			for(int i = 0; i < M; i++)
				sb.append(ans[i] + " ");
			sb.append("\n");
			set.add(sb);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			ans[idx] = list[i];
			if (check(idx))
				dfs(idx + 1);
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