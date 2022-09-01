package AlgoStudy.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ13023 {
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new LinkedList<>();
		}
		visited = new boolean[N];
		int v, u;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			graph[v].add(u);
			graph[u].add(v);
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(visited, false);
			dfs(i, 1);
			if (flag == true)
				break;

		}

		if (flag == false)
			System.out.println(0);
		else
			System.out.println(1);
	}

	static void dfs(int idx, int cnt) {
		if (cnt == 5) {
			flag = true;
			return;
		}
		visited[idx] = true;

		Iterator<Integer> iter = graph[idx].iterator();
		while (iter.hasNext()) {
			int next = iter.next();
			if (visited[next] == false) {
				dfs(next, cnt + 1);
				visited[next] = false;
			}
		}
	}
}
