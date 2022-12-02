package AlgoStudy.Week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16234 {
	static int N, L, R;
	static int[][] map;
	static int[][] union;
	static boolean[][] visited;
	static boolean[][] move_visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int sum, cnt, group;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		union = new int[N][N];
		visited = new boolean[N][N];
		move_visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int day = 0;
		while(true) {
			// init()
			group = 0;
			for(int i = 0; i < N; i++) {
				Arrays.fill(union[i], 0);
				Arrays.fill(visited[i], false);
				Arrays.fill(move_visited[i], false);
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					cnt = 0;
					sum = 0;
					group++;
					if(!visited[i][j]) {
						dfs(i, j);
						if(cnt == 1) {
							group--;
							union[i][j] = 0;
						}
						else
							move(i, j);
					}
				}
			}
			
			if(group == 0)
				break;
			day++;
		}
		
		System.out.println(day);
	}
	
	static void dfs(int x, int y) {
		int nx, ny;
		visited[x][y] = true;
		union[x][y] = group;
		sum += map[x][y];
		cnt++;
		
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx >= N || nx < 0 || ny < 0 || ny >= N)
				continue;
			if(visited[nx][ny])
				continue;
			if(Math.abs(map[x][y]-map[nx][ny]) >= L && Math.abs(map[x][y]-map[nx][ny]) <= R) 
				dfs(nx, ny);
		}
	}
	
	static void move(int x, int y) {
		int nx, ny;
		move_visited[x][y] = true;
		map[x][y] = sum / cnt;
		
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx >= N || nx < 0 || ny < 0 || ny >= N)
				continue;
			if(move_visited[nx][ny])
				continue;
			if(union[nx][ny] == group)
				move(nx, ny);
		}
	}

}
