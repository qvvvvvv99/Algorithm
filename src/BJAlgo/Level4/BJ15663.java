package BJAlgo.Level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BJ15663 {
	static int N, M;
	static int[] ary;
	static int[] res;
	static boolean[] visited;
	static LinkedHashSet<String> hs = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ary = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			ary[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(ary);
		
		res = new int[M];
		dfs(0);
		
		hs.forEach(System.out::println);
	}
	
	static void dfs(int idx) {
		if(idx == M) {
			StringBuffer sb = new StringBuffer();
			for(int num : res)
				sb.append(num).append(' ');
			hs.add(sb.toString());
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			res[idx] = ary[i];
			dfs(idx+1);
			visited[i] = false;
		}
	}

}