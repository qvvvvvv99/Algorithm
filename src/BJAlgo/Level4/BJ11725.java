package BJAlgo.Level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BJ11725 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		boolean visited[] = new boolean[N+1];
		int[] parent = new int[N+1];
		
		for(int i = 0; i <= N; i++)
			adjList[i] = new ArrayList<Integer>();
		
		for(int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		dfs(1, adjList, visited, parent);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 2; i <= N; i++)
			sb.append(parent[i]+"\n");
		
		System.out.print(sb);
	}

	public static void dfs(int v, ArrayList<Integer>[] adjList, boolean[] visited, int[] parent) {
		visited[v] = true;
		
		Iterator<Integer> iter = adjList[v].listIterator(); // 정점 인접리스트 순회
		while (iter.hasNext()) {
			int w = iter.next();
			if (!visited[w]) {
				parent[w] = v;
				dfs(w, adjList, visited, parent); 
			}
		}
	}
}
