package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ1389 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Integer>[] adjList = new LinkedList[N+1];
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		int[] res = new int[N+1];
		
		for (int i = 0; i <= N; i++)
            adjList[i] = new LinkedList<Integer>();
		
		for(int i = 0; i < M; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjList[A].add(B);
			adjList[B].add(A);
		}
		
		for(int i = 1; i <= N; i++) {
			bfs(i, adjList, dist, visited);
			for(int j = 1; j <= N; j++)
				res[i] += dist[j];
			dist = new int[N+1];
			visited= new boolean[N+1];
		}
		
		int min = Integer.MAX_VALUE;
		int idx = 0;
		for(int i= 1; i <=N; i++) {
			if(res[i] < min) {
				min = res[i];
				idx = i;
			}
		}
		
		System.out.println(idx);
	}
	
	public static void bfs(int n, LinkedList<Integer>[] adjList, int dist[], boolean visited[]) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(n);
		visited[n] = true;
		
		while(queue.size() != 0) {
			n = queue.poll();
			
			Iterator<Integer> iter = adjList[n].listIterator();
            while(iter.hasNext()) { 
                int w = iter.next(); 
                if(!visited[w]) { 
                    visited[w] = true; 
                    queue.add(w); 
                    dist[w] = dist[n]+1;
                } 
            }
		}
	}

}
