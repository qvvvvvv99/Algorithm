package AlgoStudy.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1103 {
	static char[][] map;
	static int N, M;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	static int res = 0;
	static boolean flag; // 무한루프 존재여부
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		dp = new int[N][M];
		String line;
	
		for(int i = 0; i < N; i++) {
			line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		dfs(0,0,1);
		
		System.out.println(res);
	}
	
	public static void dfs(int x, int y, int cnt) {
		visited[x][y] = true;
		dp[x][y] = cnt;
		res = Math.max(res, cnt);
		int nextX, nextY;
		
		for(int i = 0; i < 4; i++) {
			nextX = x + (map[x][y] - '0') * dx[i];
			nextY = y + (map[x][y] - '0') * dy[i];
			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 'H') {
				continue;
			}
			if(cnt < dp[nextX][nextY])
				continue;
			
			if(visited[nextX][nextY] == true) {
				res = -1;
				flag = true;
				return;
			}

			visited[nextX][nextY] = true;
			dfs(nextX, nextY, cnt+1);
			visited[nextX][nextY] = false;
			
			if(flag == true)
				return;
		}
	}

}
