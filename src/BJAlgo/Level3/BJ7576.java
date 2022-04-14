package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ7576 {
	static int[] rotX = { 1, 0, -1, 0 };
	static int[] rotY = { 0, 1, 0, -1 };
	static Queue<int[]> queue;
	static int[][] map;
	static int[][] day;
	static int M, N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		day = new int[N][M];
		queue = new LinkedList<>();
		int res = 0;
		boolean flag = true;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					queue.add(new int[] { i, j });
			}
		}

		dfs();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					flag = false;
					break;
				}
			}
		}
		
		if(flag == true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					res = Math.max(res, day[i][j]);
				}
			}
			System.out.println(res);
		}	
		else
			System.out.println(-1);
	}

	public static void dfs() {
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int n = 0; n < 4; n++) {
				int nextX = curr[1] + rotX[n];
				int nextY = curr[0] + rotY[n];
				if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
					continue;
				if (map[nextY][nextX] == 0) {
					map[nextY][nextX] = 1;
					queue.add(new int[] { nextY, nextX });
					day[nextY][nextX] = day[curr[0]][curr[1]] + 1;
				}
			}
		}
	}
}
