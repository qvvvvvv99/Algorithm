package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16918 {
	static int R, C, N;
	static String[] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new String[R];
		boolean flag = true;
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < R; i++)
			map[i] = br.readLine();

		if (N == 1) {
		} else if (N == 2) {
			for (int i = 0; i < R; i++) {
				map[i] = "";
				for (int j = 0; j < C; j++) {
					map[i] += "O";
				}
			}
		} else {
			boolean[][] visited = new boolean[R][C];
			boolean[][] bomb = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (visited[i][j])
						continue;
					if (map[i].charAt(j) == 'O') {
						visited[i][j] = true;
						bomb[i][j] = true;
						int nx, ny;
						for (int d = 0; d < 4; d++) {
							nx = i + dx[d];
							ny = j + dy[d];
							if (nx < 0 || nx >= R || ny < 0 || ny >= C)
								continue;
							if (map[nx].charAt(ny) == '.') {
								bomb[nx][ny] = true;
								visited[nx][ny] = true;
							}
						}
					}
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (!bomb[i][j]) {
						flag = false;
						break;
					}
				}
				if (!flag)
					break;
			}

			if (!flag) {
				if (N % 2 == 0) {
					for (int i = 0; i < R; i++) {
						map[i] = "";
						for (int j = 0; j < C; j++) {
							map[i] += "O";
						}
					}
				} else if (N % 4 == 3) {
					for (int i = 0; i < R; i++) {
						map[i] = "";
						for (int j = 0; j < C; j++) {
							if (bomb[i][j])
								map[i] += ".";
							else
								map[i] += "O";
						}
					}
				}
			} else {
				for (int i = 0; i < R; i++) {
					map[i] = "";
					for (int j = 0; j < C; j++) {
						if (N % 4 == 3)
							map[i] += ".";
						else
							map[i] += "O";
					}
				}
			}
		}
		for (int i = 0; i < R; i++)
			sb.append(map[i]).append("\n");

		System.out.print(sb);
	}

}
