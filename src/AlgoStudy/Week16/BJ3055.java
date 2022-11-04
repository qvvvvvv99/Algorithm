package AlgoStudy.Week16;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ3055 {
	static int[] rotX = { -1, 0, 1, 0 };
	static int[] rotY = { 0, 1, 0, -1 };
	static int R, C;
	static int min;
	static int[][] time;
	static boolean[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		int x = 0, y = 0;

		char[][] map = new char[R][C];
		time = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String line = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'S') {
					x = i;
					y = j;
				}
			}
		}
		min = Integer.MAX_VALUE;

		bfs(map, x, y, 0);

		if (min < Integer.MAX_VALUE)
			System.out.println(min);
		else
			System.out.println("KAKTUS");
	}

	static void bfs(char[][] map, int x, int y, int sec) {
		Queue<info> queue = new LinkedList<>();
		int nx, ny;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					queue.add(new info(i, j, 'w'));
				}
			}
		}
		queue.add(new info(x, y, 's'));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			info curr = queue.poll();
			if (curr.c == 's') {
				if (map[curr.x][curr.y] == 'D') {
					min = Math.min(min, time[curr.x][curr.y]);
				}
			}
			for (int i = 0; i < 4; i++) {
				nx = curr.x + rotX[i];
				ny = curr.y + rotY[i];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C)
					continue;
				if (curr.c == 'w') {
					if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
						queue.add(new info(nx, ny, 'w'));
						map[nx][ny] = '*';
					}
				} else if (curr.c == 's') {
					if (map[nx][ny] != 'X' && map[nx][ny] != '*') {
						if (visited[nx][ny] == false) {
							queue.add(new info(nx, ny, 's'));
							visited[nx][ny] = true;
							time[nx][ny] = time[curr.x][curr.y] + 1;
						}
					}
				}
			}
		}

	}

}

class info {
	int x;
	int y;
	char c;

	info(int x, int y, char c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
}
