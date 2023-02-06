package AlgoStudy.M2_W1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1765 {
	static int[] parent;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		cnt = n;
		LinkedList<Integer>[] EnemyMap = new LinkedList[n+1];
		LinkedList<Integer>[] FreindMap = new LinkedList[n+1];
		for(int i = 1; i <= n; i++) {
			EnemyMap[i] = new LinkedList<>();
			FreindMap[i] = new LinkedList<>();
			parent[i] = i;
		}
		
		StringTokenizer st;
		char c;
		int v, u;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			c = st.nextToken().charAt(0);
			v = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			if(c == 'F') {
				union(u, v);
				FreindMap[u].add(v);
				FreindMap[v].add(u);
			}
			else {
				EnemyMap[u].add(v);
				EnemyMap[v].add(u);
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j : EnemyMap[i]) {
				for(int k : EnemyMap[j]) {
					union(i, k);
				}
			}
		}
		
		System.out.println(cnt);
	}

	static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		
		if(v1 != v2) {
			parent[v2] = v1;
			cnt--;
		}
		return;
	}
	
	static int find(int v) {
		if(v == parent[v])
			return v;
		return parent[v] = find(parent[v]);
	}
}
