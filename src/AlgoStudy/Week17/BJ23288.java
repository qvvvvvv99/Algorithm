package AlgoStudy.Week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ23288 {
	static int N, M, K, dir, curX, curY;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dice = { 6, 3, 4, 5, 2, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int score = 0;

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		// 처음은 동쪽 방향 이동
		curX = 0;
		curY = 0;
		for (int i = 0; i < K; i++) {
			// 이동방향으로 갈 수 있는지
			isAvailable();
			// 이동하기
			move();
			// 점수 획득하기
			score += map[curX][curY] * bfs();
		}

		System.out.println(score);
	}

	static void isAvailable() {
		// TODO Auto-generated method stub
		int nx = curX + dx[dir];
		int ny = curY + dy[dir];

		if (0 > nx && dir == 3)
			dir = 1;
		else if (nx >= N && dir == 1)
			dir = 3;
		else if (0 > ny && dir == 2) 
			dir = 0;
		else if (ny >= M && dir == 0) 
			dir = 2;
	}

	private static void move() {
		// TODO Auto-generated method stub
		curX = curX + dx[dir];
		curY = curY + dy[dir];

		dice_change();
		dir_change();
	}

	static void dir_change() {
		// TODO Auto-generated method stub
		if (dice[0] > map[curX][curY]) 
			dir += 1;
		else if (dice[0] < map[curX][curY]) 
			dir -= 1;

		if (dir >= 4) 
			dir -= 4;
		else if (dir < 0) 
			dir += 4;
	}

	static void dice_change() {
		// TODO Auto-generated method stub
		int[] tmp = new int[6];
		for (int i = 0; i < 6; i++) {
			tmp[i] = dice[i];
		}

		if (dir == 0) {
			dice[0] = tmp[1];
			dice[1] = tmp[5];
			dice[2] = tmp[0];
			dice[3] = tmp[3];
			dice[4] = tmp[4];
			dice[5] = tmp[2];
		} else if (dir == 1) {
			dice[0] = tmp[3];
			dice[1] = tmp[1];
			dice[2] = tmp[2];
			dice[3] = tmp[5];
			dice[4] = tmp[0];
			dice[5] = tmp[4];
		} else if (dir == 2) {
			dice[0] = tmp[2];
			dice[1] = tmp[0];
			dice[2] = tmp[5];
			dice[3] = tmp[3];
			dice[4] = tmp[4];
			dice[5] = tmp[1];
		} else if (dir == 3) {
			dice[0] = tmp[4];
			dice[1] = tmp[1];
			dice[2] = tmp[2];
			dice[3] = tmp[0];
			dice[4] = tmp[5];
			dice[5] = tmp[3];
		}
	}

	static int bfs() {
		// TODO Auto-generated method stub
		Queue<int[]> queue = new LinkedList<int[]>();
		check = new boolean[N][M];
		queue.add(new int[] { curX, curY });
		check[curX][curY] = true;
		int point = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 > nx || nx >= N || 0 > ny || ny >= M)
					continue;

				if (map[x][y] == map[nx][ny] && check[nx][ny] == false) {
					point++;
					check[nx][ny] = true;
					queue.add(new int[] { nx, ny });
				}
			}
		}

		return point;
	}
}
