package BJAlgo.Level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7569 {
	static int[] rotX = { 1, 0, -1, 0, 0, 0};
	static int[] rotY = { 0, 1, 0, -1, 0, 0};
	static int[] rotZ = { 0, 0, 0, 0, -1, 1};
	static Queue<int[]> queue;
	static int[][][] map;
	static int[][][] day;
	static int M, N, H;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][M][H];
		day = new int[N][M][H];
		queue = new LinkedList<>();
		int res = 0;
		boolean flag = true;

		for (int z = 0; z < H; z++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j][z] = Integer.parseInt(st.nextToken());
					if (map[i][j][z] == 1) 
						queue.add(new int[] {i, j, z});
				}
			}
		}
		
		dfs();
		for (int z = 0; z < H; z++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j][z] == 0) {
						flag = false;
						break;
					}
				}
			}
		}

		if (flag == true) {
			for (int z = 0; z < H; z++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						res = Math.max(res, day[i][j][z]);
					}
				}
			}
			System.out.println(res);
		} else
			System.out.println(-1);
	}

	public static void dfs() {
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int n = 0; n < 6; n++) {
				int nextX = curr[1] + rotX[n];
				int nextY = curr[0] + rotY[n];
				int nextZ = curr[2] + rotZ[n];
				if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || nextZ < 0 || nextZ >= H)
					continue;
				if (map[nextY][nextX][nextZ] == 0) {
					map[nextY][nextX][nextZ] = 1;
					queue.add(new int[] { nextY, nextX, nextZ});
					day[nextY][nextX][nextZ] = day[curr[0]][curr[1]][curr[2]] + 1;
				}
			}
		}
	}
}
