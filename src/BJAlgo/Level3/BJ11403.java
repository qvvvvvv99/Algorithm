package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ11403 {
	static int[][] graph;
	static int[][] res;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();

		graph = new int[N + 1][N + 1];
		res = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for (int j = 1; j <= N; j++)
				graph[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++)
			bfs(i);

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				sb.append(res[i][j] + " ");
			sb.append("\n");
		}

		br.close();
		System.out.print(sb);
	}

	static public void bfs(int fir) {
		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			if (graph[fir][i] == 1) {
				res[fir][i] = 1;
				queue.add(i);
				visited[i] = true;
			}
		}

		while (!queue.isEmpty()) {
			int n = queue.poll();
			for(int i = 1; i <= N; i++) {
				if(graph[n][i] == 1 && visited[i] == false) {
					res[fir][i] = 1;
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

}
