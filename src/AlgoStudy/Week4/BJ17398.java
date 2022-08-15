package AlgoStudy.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17398 {
	static int[][] conn;
	static int[] remove;
	static int[] parent;
	static long[] setCnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		conn = new int[M+1][2];
		remove = new int[Q+1];
		parent = new int[N+1];
		setCnt = new long[2];
		boolean[] check = new boolean[M+1];
		for(int i = 1; i <= N; i++)
			parent[i] = i;
		long res = 0;
		int a, b;
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			conn[i][0] = Integer.parseInt(st.nextToken());
			conn[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= Q; i++) {
			remove[i] = Integer.parseInt(br.readLine());
			check[remove[i]] = true;
		}
		
		// 끊을 정점을 연결하기 전에 나누어진 통신망의 수를 확인한다.
		for(int i = 1; i <= M; i++) {
			if(check[i] == false) {
				a = find(conn[i][0]);
				b = find(conn[i][1]);
				if(a != b)
					union(a,b);
			}
		}
		a = find(conn[remove[Q]][0]);
		b = find(conn[remove[Q]][1]);
		if(a != b) {
			for(int i = 1; i <= N; i++) {
				if(parent[i] == a)
					setCnt[0]++;
				else if(parent[i] == b)
					setCnt[1]++;
			}
			union(a, b);
			res += setCnt[0] * setCnt[1];
		}
		
		for(int i = Q-1; i > 0; i--) {
			Arrays.fill(setCnt, 0);
			a = find(conn[remove[i]][0]);
			b = find(conn[remove[i]][1]);
			if(a != b) {
				for(int j = 1; j <= N; j++) {
					if(parent[j] == a)
						setCnt[0]++;
					else if(parent[j] == b)
						setCnt[1]++;
				}
				union(a, b);
				res += setCnt[0] * setCnt[1];
			}
		}
		
		System.out.println(res);
	}
	
	static int find(int a) {
		return parent[a] == a ? a : find(parent[a]);
	}

	static void union(int a, int b) {
		parent[Math.max(a, b)] = Math.min(a, b);
	}
}
