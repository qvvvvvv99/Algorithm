package AlgoStudy.M2_W1;

import java.util.Scanner;

public class BJ1189 {
	static int R, C, K;
	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][] visited;
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		
		visited = new boolean[R][C];
		map = new char[R][C];
		String line;
		for(int i = 0; i < R; i++) {
			line = sc.next();
			for(int j = 0; j < C; j++)
				map[i][j] = line.charAt(j);
		}
		
		visited[R-1][0] = true;
		dfs(R-1, 0, 1);
		
		System.out.println(cnt);
	}

	static void dfs(int x, int y, int n) {
		if(n == K) {
			if(x == 0 && y == C-1)
				cnt++;
			return;
		}
		
		int nx, ny;
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C)
				continue;
			if(visited[nx][ny] || map[nx][ny] == 'T')
				continue;
			visited[nx][ny] = true;
			n++;
			dfs(nx, ny, n);
			n--;
			visited[nx][ny] = false;
		}
	}
}
