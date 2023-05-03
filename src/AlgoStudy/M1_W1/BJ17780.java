package AlgoStudy.M1_W1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17780 {
	static int N, K;
	static int[][] map, cnt, bottom, top;
	static int[][] chess;
	static boolean[] canMove;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean flag = false;
	static int freeze;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		cnt = new int[N][N];
		bottom = new int[N][N];
		top = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		freeze = K;
		canMove = new boolean[K];
		Arrays.fill(canMove, true);
		chess = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				chess[i][j] = Integer.parseInt(st.nextToken()) - 1;
			bottom[chess[i][0]][chess[i][1]] = i;
			top[chess[i][0]][chess[i][1]] = i;
			cnt[chess[i][0]][chess[i][1]] = 1;
		}

		int turn = 1;
		int nx, ny;
		while (turn <= 1000) {
			for (int i = 0; i < K; i++) {
				if (!canMove[i])
					continue;
				nx = chess[i][0] + dx[chess[i][2]];
				ny = chess[i][1] + dy[chess[i][2]];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 2) {
					nextBlue(i);
					continue;
				}
				move(i, nx, ny);
				if (flag || freeze == 0)
					break;
			}
			if (flag || freeze == 0)
				break;
			turn++;
		}

		if (turn > 1000)
			turn = -1;
		System.out.println(turn);
	}

	static void move(int idx, int nx, int ny) {
		if (cnt[chess[idx][0]][chess[idx][1]] + cnt[nx][ny] >= 4) {
			flag = true;
			return;
		}
		// ������ �Ʒ��� ������ �ٲ޿� �־� ���� ���� ���� �Ʒ��� �ʿ�
		int t = top[chess[idx][0]][chess[idx][1]];
		// �̵� ��ġ�� �̹� �����ϸ� ������ ���� ���δ�
		if (cnt[nx][ny] > 0) {
			canMove[idx] = false;
			freeze--;
		}
		// ����ĭ �Ͼ�
		if (map[nx][ny] == 0) {
			if(cnt[nx][ny] == 0)
				bottom[nx][ny] = idx;
			top[nx][ny] = t;
		}
		// ����ĭ ����
		else {
			if(cnt[nx][ny] == 0) {
				bottom[nx][ny] = t;
				canMove[idx] = false;
				canMove[t] = true;
			}
			top[nx][ny] = idx;
		}
		cnt[nx][ny] += cnt[chess[idx][0]][chess[idx][1]];
		cnt[chess[idx][0]][chess[idx][1]] = 0;
		chess[idx][0] = nx;
		chess[idx][1] = ny;
		chess[t][0] = nx;
		chess[t][1] = ny;
	}

	static void nextBlue(int idx) {
		int nx, ny;

		if (chess[idx][2] % 2 == 0)
			chess[idx][2]++;
		else
			chess[idx][2]--;

		nx = chess[idx][0] + dx[chess[idx][2]];
		ny = chess[idx][1] + dy[chess[idx][2]];
		if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 2) {
			canMove[idx] = false;
			freeze--;
			return;
		}

		move(idx, nx, ny);
	}

}
