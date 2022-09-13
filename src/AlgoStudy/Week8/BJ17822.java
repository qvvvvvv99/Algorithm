package AlgoStudy.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17822 {
	static int N, M;
	static int[][] circle;
	static int[] first;
	static boolean[][] visited;
	static int cnt;
	static boolean flag, change;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		circle = new int[N][M];
		visited = new boolean[N][M];
		first = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x, d, k;
		cnt = N * M;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			int n;
			for (int i = 1; i < N; i++) {
				n = i * x;
				if (n > N)
					break;
				rotate(n - 1, d, k);
			}

			if (cnt == 0)
				break;
			visited = new boolean[N][M];
			check();
		}

		if (cnt == 0)
			System.out.println(0);
		else {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sum += circle[i][j];
				}
			}
			System.out.println(sum);
		}
	}

	static void rotate(int idx, int d, int k) {
		if (d == 0) {
			if (first[idx] < k)
				first[idx] = M - (k - first[idx]);
			else
				first[idx] -= k;
		} else {
			first[idx] += k;
			first[idx] %= M;
		}
	}

	static void check() {
		change = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (circle[i][j] == 0 || visited[i][j] == true)
					continue;
				visited[i][j] = true;
				flag = false;
				dfs(i, j, circle[i][j]);
				if (flag == true) {
					circle[i][j] = 0;
					cnt--;
					change = true;
				}
			}
		}
		
		if(change == false) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					sum += circle[i][j];
				}
			}
			float avg = (float)sum / cnt;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(circle[i][j] == 0)
						continue;
					if((float)circle[i][j] < avg)
						circle[i][j]++;
					else if((float)circle[i][j] > avg)
						circle[i][j]--;
				}
			}
		}
	}

	static void dfs(int x, int y, int n) {
		int adjX, adjY, move;
		for (int i = 0; i < 4; i++) {
			adjX = x + dx[i];
			if(adjX < 0 || adjX >= N)
				continue;
			if (i % 2 == 0) {
				move = first[adjX] - first[x];

				if (move < 0) 
					adjY = M + (y + move);
				else
					adjY = y + move;
				adjY %= M;
			}
			else {
				adjY = y + dy[i];
				if(adjY < 0)
					adjY = M - 1;
				if(adjY >= M)
					adjY = 0;
			}

			if (visited[adjX][adjY] == false && circle[adjX][adjY] == n) {
				visited[adjX][adjY] = true;
				circle[adjX][adjY] = 0;
				cnt--;
				flag = true;
				dfs(adjX, adjY, n);
			}
		}

	}
}
