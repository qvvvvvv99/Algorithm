package AlgoStudy.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1976 {
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] route = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int j = 0; j < M; j++) 
			route[j] = Integer.parseInt(st.nextToken())-1;
		
		
		int u, v;
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if(map[i][j] == 1) {
					u = find(i);
					v = find(j);
					if(u != v)
						union(u, v);
				}
			}
		}
		
		boolean flag = false;
		int g = find(route[0]);
		for(int i = 1; i < M; i++) {
			if(find(route[i]) != g) {
				flag = true;
				break;
			}
		}
		
		if(flag == true)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
	
	static int find(int a) {
		return parent[a] == a ? a : find(parent[a]);
	}

	static void union(int a, int b) {
		parent[Math.max(a, b)] = Math.min(a, b);
	}
}
