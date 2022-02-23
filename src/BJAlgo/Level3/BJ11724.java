package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ11724 {
	static int[] ary;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String MN = br.readLine();
		StringTokenizer st = new StringTokenizer(MN);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ary = new int[N+1];
		for(int i = 1; i <= N; i++) {
			ary[i] = i;
		}
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			u = find(u);
			v = find(v);
			if(u != v)
				union(u, v);
		}
		
		HashSet<Integer> set = new HashSet<>();
		for(int i = 1; i <= N; i++) {
			set.add(find(i));
		}
		
		System.out.println(set.size());
	}
	
	public static int find(int n) {
		if(ary[n] == n)
			return n;
		return find(ary[n]);
	}
	
	public static void union(int u, int v) {
		ary[v] = u;
	}

}
