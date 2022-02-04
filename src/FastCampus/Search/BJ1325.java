package FastCampus.Search;

// BJ 1325번 효율적인 해킹
// BFS
// 시간 제한 5초임에도 시간 초과남ㅠㅠ

import java.io.*;
import java.util.*;

public class BJ1325 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] res = new int[N + 1];
		boolean visited[] = new boolean[N + 1];

		LinkedList<Integer> adjList[] = new LinkedList[N + 1];

		for (int i = 1; i <= N; i++)
			adjList[i] = new LinkedList();

		for (int i = 0; i < M; i++) {
			String[] inputs = br.readLine().split(" ");
			adjList[Integer.parseInt(inputs[1])].add(Integer.parseInt(inputs[0]));
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			int cnt = bfs(i, adjList, visited);
			max = Math.max(max, cnt);
			res[i] = cnt;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (res[i] == max)
				sb.append(i+" ");
		}
		System.out.println(sb.toString());
	}

	public static int bfs(int start, LinkedList<Integer>[] adjList, boolean[] visited) {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.add(start);

		while (queue.size() != 0) {
			start = queue.poll();
			cnt++;
			
			for(int next : adjList[start]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
		return cnt;
	}
}
