package AlogStudy.M1_W1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ15591 {
	static int N, Q;
	static LinkedList<Value>[] graph;
	static boolean[] visited;
	static int[][] usado;
	static int start = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		graph = new LinkedList[N+1];
		for(int i = 1; i <= N; i++)
			graph[i] = new LinkedList<>();

		int p, q, r;
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			graph[p].add(new Value(q, r));
			graph[q].add(new Value(p, r));
		}
		
		visited = new boolean[N+1];
		usado = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			Arrays.fill(visited, false);
			start++;
			visited[i] = true;
			dfs(i, Integer.MAX_VALUE);
		}
		
		StringBuffer sb = new StringBuffer();
		int k, v, cnt;
		for(int i = 1; i <= Q; i++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			cnt = 0;
			for(int j = 1; j <= N; j++) {
				if(usado[v][j] >= k)
					cnt++;
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	}

	static void dfs(int v, int min) {
		int next, p;
		
		for(int i = 0; i < graph[v].size(); i++) {
			next = graph[v].get(i).desti;
			p = graph[v].get(i).price;
			if(!visited[next]) {
				visited[next] = true;
				usado[start][next] = Math.min(min, p);
				dfs(next, Math.min(min, p));
			}
		}
	}
}

class Value{
	int desti;
	int price;
	
	Value(int desti, int price){
		this.desti = desti;
		this.price = price;
	}
}
