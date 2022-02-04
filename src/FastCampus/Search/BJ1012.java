package FastCampus.Search;

import java.io.*;

public class BJ1012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			String input[] = br.readLine().split(" ");
			int M = Integer.parseInt(input[0]);
			int N = Integer.parseInt(input[1]);
			int K = Integer.parseInt(input[2]);
			int[][] map = new int[N + 2][M + 2];
			int[][] visited = new int[N + 2][M + 2];
			int cnt = 0;

			for (int i = 0; i < K; i++) {
				input = br.readLine().split(" ");
				int a = Integer.parseInt(input[0]) + 1;
				int b = Integer.parseInt(input[1]) + 1;
				map[b][a] = 1;
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (map[i][j] == 1 && visited[i][j] == 0) {
						dfs(i, j, map, visited);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}

	public static void dfs(int y, int x, int[][] map, int[][] visited) {
		visited[y][x] = 1;
		int nextY, nextX;

		// ╩С
		nextY = y-1;
		nextX = x;
		if (visited[nextY][nextX] == 0 && map[nextY][nextX] == 1)
			dfs(nextY, nextX, map, visited);
		// ©Л
		nextY = y;
		nextX = x+1;
		if (visited[nextY][nextX] == 0 && map[nextY][nextX] == 1)
			dfs(nextY, nextX, map, visited);
		// го
		nextY = y+1;
		nextX = x;
		if (visited[nextY][nextX] == 0 && map[nextY][nextX] == 1)
			dfs(nextY, nextX, map, visited);
		// аб
		nextY = y;
		nextX = x-1;
		if (visited[nextY][nextX] == 0 && map[nextY][nextX] == 1)
			dfs(nextY, nextX, map, visited);
	}
}
