package FastCampus.Search;

// BJ 1260번 DFS & BFS
// DFS & BFS 는 필수!!!
// 많이 풀어봐서 흐름 암기하기!!(코드코드)

import java.util.*;

public class BJ1260 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 정점의 개수 
		int m = sc.nextInt(); // 간선의 개수 
		int v = sc.nextInt(); // 탐색을 시작할 정점의 번호 

		boolean visited[] = new boolean[n + 1]; // 방문 여부를 검사할 배열 

		LinkedList<Integer>[] adjList = new LinkedList[n + 1];

		for (int i = 0; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		for (int i = 1; i <= n; i++)
			Collections.sort(adjList[i]);
		// 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문 
		// 하기 위해 인접리스트 내 정렬
		
		dfs(v, adjList, visited);
		Arrays.fill(visited, false);
		System.out.println();
		bfs(v, adjList, visited);
	}
	
	public static void dfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		
		Iterator<Integer> iter = adjList[v].listIterator();
		while(iter.hasNext()) {
			int w = iter.next();
			if(!visited[w])
				dfs(w, adjList, visited);
		}
	}
	
	public static void bfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = true;
		
		while(queue.size() != 0) {
			v = queue.poll();
			System.out.print(v + " ");
			
			Iterator<Integer> iter = adjList[v].listIterator();
			while(iter.hasNext()) {
				int w= iter.next();
				if(!visited[w]) {
					queue.add(w);
					visited[w] = true;
				}
			}
		}
	}

}
