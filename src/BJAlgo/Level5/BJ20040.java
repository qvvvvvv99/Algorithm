package BJAlgo.Level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20040 {
	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N];
		for(int i = 0; i < N; i++)
			parent[i] = i;
		
		int res = 0;
		int a, b;
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			a = find(a);
			b = find(b);
			if(a != b)
				union(a,b);
			else {
				if(res == 0)
					res = i;
				continue;
			}
		}
		
		System.out.println(res);
	}

	static int find(int v) {
		if(v == parent[v])
			return v;
		return parent[v] = find(parent[v]);
	}
	
	static void union(int a, int b) {
		parent[Math.max(a, b)] = Math.min(a, b);
	}
}
