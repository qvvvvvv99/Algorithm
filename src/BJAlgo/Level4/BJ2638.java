package BJAlgo.Level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2638 {
	static int R, C, num = 0;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int res = 0;
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					num++;
			}
		}
		
		while(true) {
			// 1. 치즈 갯수 확인
			if(num == 0)
				break;
			// 2. 외부 공기 확인
			for(int i = 0; i < R; i++)
				Arrays.fill(visited[i], false);
			visited[0][0] = true;
			dfs(0, 0);
			// 3. 치즈 접촉 확인
			check();
			res++;
		}
		
		System.out.println(res);
	}
	
	static void dfs(int x, int y) {
		int nx, ny;
		
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C)
				continue;
			if(visited[nx][ny] || map[nx][ny] == 1)
				continue;
			map[nx][ny] = 2;
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
	
	static void check() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 1) {
					int n = 0;
					for(int d = 0; d < 4; d++) {
						if(map[i+dx[d]][j+dy[d]] == 2)
							n++;
					}
					if(n >= 2) {
						map[i][j] = 0;
						num--;
					}
				}
			}
		}
	}

}
