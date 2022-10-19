package AlgoStudy.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ17070 {
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 1, 0 };
	static int[][] map;
	static int cnt = 0;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		String line;
		String[] nums = new String[N];
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			nums = line.split(" ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(nums[j]);
		}

		// (끝부분x좌표, 끝부분y좌표, 막대 방향)
		dfs(0, 1, 1);

		System.out.println(cnt);
	}

	static void dfs(int x, int y, int dir) {
		if (x == N - 1 && y == N - 1) {
			cnt++;
			return;
		}
		int nx, ny;
		int i;
		// 1 : 가로
		if (dir == 1) {
			for (i = 0; i < 3; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					break;
				if(map[nx][ny] == 1)
					break;
				// 다음 가로
				if (i == 0)
					dfs(x, y + 1, 1);
			}
			// 다음 대각선
			if(i == 3)
				dfs(x + 1, y + 1, 3);
		}
		// 2 : 세로
		else if (dir == 2) {
			for(i = 2; i >= 0; i--) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					break;
				if(map[nx][ny] == 1)
					break;
				// 다음 세로
				if(i == 2)
					dfs(x + 1, y, 2);
			}
			// 다음 대각선
			if(i == -1)
				dfs(x + 1, y + 1, 3);
		}
		// 3 : 대각선
		else {
			int j = 0;
			for (i = 0; i < 3; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if(map[nx][ny] == 1)
					continue;
				j++;
				// 다음 가로
				if (i == 0)
					dfs(x, y + 1, 1);
				// 다음 세로
				else if(i == 2)
					dfs(x + 1, y, 2);
			}
			// 다음 대각선
			if(j == 3)
				dfs(x + 1, y + 1, 3);
		}
	}

}
