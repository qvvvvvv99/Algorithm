package AlgoStudy.M1_W4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17837 {
	static int N, K;
	static int[][] map, cnt;
	static int[][][] chess;
	static int[][] horse;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		cnt = new int[N+1][N+1];
		chess = new int[N+1][N+1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		horse = new int[K+1][3];
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++)
				horse[i][j] = Integer.parseInt(st.nextToken());
			horse[i][2] = Integer.parseInt(st.nextToken())-1;
			chess[horse[i][0]][horse[i][1]][0] = i;
			cnt[horse[i][0]][horse[i][1]] = 1;
		}

		int turn = 1;
		int nx, ny;
		while (turn <= 1000) {
			for (int i = 1; i <= K; i++) {
				nx = horse[i][0] + dx[horse[i][2]];
				ny = horse[i][1] + dy[horse[i][2]];
				if (nx < 1 || nx > N || ny < 1 || ny > N || map[nx][ny] == 2) {
					nextBlue(i);
					continue;
				}
				move(i, nx, ny);
				if (flag)
					break;
			}
			if (flag)
				break;
			turn++;
		}

		if (turn > 1000)
			turn = -1;
		System.out.println(turn);
	}

	static void move(int idx, int nx, int ny) {		
		int n = cnt[horse[idx][0]][horse[idx][1]];
		int nn = cnt[nx][ny];
		
		int i;
		for(i = 0; i < 3; i++) {
			if(chess[horse[idx][0]][horse[idx][1]][i] == idx)
				break;
		}
		if (n - i + nn >= 4) {
			flag = true;
			return;
		}
		
		// ´ÙÀ½Ä­ ÇÏ¾ç
		if (map[nx][ny] == 0) {
			for(int j = i; j < n; j++)
				chess[nx][ny][nn+j-i] = chess[horse[idx][0]][horse[idx][1]][j];
		}
		// ´ÙÀ½Ä­ »¡°­
		else {
			int ii = 0;
			for(int j = n-1; j >= i; j--, ii++) {
				chess[nx][ny][nn+ii] = chess[horse[idx][0]][horse[idx][1]][j];
			}
		}
		
		int x = horse[idx][0];
		int y = horse[idx][1];
		for(int j = i; j < n; j++) {
			cnt[nx][ny]++;
			cnt[x][y]--;
			horse[chess[nx][ny][nn+j-i]][0] = nx;
			horse[chess[nx][ny][nn+j-i]][1] = ny;
		}
	}

	static void nextBlue(int idx) {
		int nx, ny;

		if (horse[idx][2] % 2 == 0)
			horse[idx][2]++;
		else
			horse[idx][2]--;

		nx = horse[idx][0] + dx[horse[idx][2]];
		ny = horse[idx][1] + dy[horse[idx][2]];
		if (nx < 1 || nx > N || ny < 1 || ny > N || map[nx][ny] == 2) 
			return;
		
		move(idx, nx, ny);
	}
}
