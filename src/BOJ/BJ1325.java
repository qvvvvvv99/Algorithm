package BOJ;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ1325 {
	static int N, M;
	static int[] pNum;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pNum = new int[N+1];
		int min = Integer.MAX_VALUE;
		StringBuffer sb = new StringBuffer();
		
		int[] indegree = new int[N+1];
		List<Integer>[] adjList = new ArrayList[N+1];
		
		for(int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			indegree[a]++;
			adjList[b].add(a);
		}
		
		for(int i = 1; i <= N; i++) {
			if(min > indegree[i]) {
				min = indegree[i];
			}
		}
		
		for(int i = 1; i<=N; i++) {
			if(indegree[i] == min) {
				bfs(i, adjList);
			}
		}
		
		int max = 0;
		for(int i = 1; i <= N; i++)
			max = Math.max(max, pNum[i]);
		
		for(int i = 1; i <= N; i++) {
			if(pNum[i] == max)
				sb.append(i + " ");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int root, List<Integer>[] adjList) {
		boolean[] visited = new boolean[N+1];
		visited[root] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(root);
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			cnt++;
			
			Iterator<Integer> iter = adjList[v].listIterator();
            while(iter.hasNext()) { 
                int w = iter.next(); 
                if(!visited[w]) { 
                	pNum[root]++;
                    visited[w] = true; 
                    queue.add(w); 
                } 
            }
		}
		
	}

}
