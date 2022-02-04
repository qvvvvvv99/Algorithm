package FastCampus.Search;

// BJ 2606번 바이러스

import java.util.*;

public class BJ2606 {
	static int cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int comNum = sc.nextInt();
		int netNum = sc.nextInt();
		LinkedList<Integer>[] adjList = new LinkedList[comNum+1];
		boolean visited[] = new boolean[comNum+1];
		
		for(int i = 1; i <= comNum; i++)
			adjList[i] = new LinkedList();
		
		for(int i = 0; i < netNum; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		dfs(1, adjList, visited);
		System.out.println(cnt-1);
	}

	public static void dfs(int v, LinkedList[] adjList, boolean[] visited) {
		visited[v] = true;
		cnt++;
		
		Iterator<Integer> iter = adjList[v].listIterator();
		while(iter.hasNext()) {
			int w = iter.next();
			if(!visited[w]) {
				dfs(w, adjList, visited);
			}
		}
	}
}
