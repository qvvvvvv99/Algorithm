package BJAlgo.Level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1167 {
	static ArrayList<Ver>[] tree;
	static int len = 0, num;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			tree[i] = new ArrayList<>();
		
		int u, v, d;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				v = Integer.parseInt(st.nextToken());
				if(v == -1)
					break;
				d = Integer.parseInt(st.nextToken());
				
				tree[u].add(new Ver(v, d));
			}
		}
		
		visited = new boolean[N+1];
		dfs(1, 0);
		visited = new boolean[N+1];
		dfs(num, 0);
		
		System.out.println(len);
	}

	static void dfs(int idx, int sum) {
		visited[idx] = true;
		
		if(sum > len) {
			num = idx;
			len = sum;
		}
		
		for(int i = 0; i < tree[idx].size(); i++) {
			Ver u = tree[idx].get(i);
			if(visited[u.v])
				continue;
			dfs(u.v, sum + u.d);
		}
	}
}

class Ver {
	int v, d;
	
	Ver (int v, int d){
		this.v = v;
		this.d = d;
	}
}
