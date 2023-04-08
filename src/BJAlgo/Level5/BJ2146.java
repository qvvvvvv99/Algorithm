package BJAlgo.Level5;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2146 {
	static int N;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int min = 1000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					map[i][j] = -1;
			}
		}
		
		int num = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == -1) {
					dfs(i, j, num);
					num++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] > 0) {
					bfs(i, j, map[i][j]);
				}
			}
		}
		
		System.out.println(min);
	}
	
	static void dfs(int x, int y, int n) {
		map[x][y] = n;
		
		int nx, ny;
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if(map[nx][ny] == -1)
				dfs(nx, ny, n);
		}
	}

	static void bfs(int x, int y, int n) {
		int[][] len = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visited[x][y] = true;
		
		Point curr;
		int nx, ny;
		boolean flag = false;
		while(!queue.isEmpty()) {
			curr = queue.poll();
			for(int i = 0; i < 4; i++) {
				nx = curr.x + dx[i];
				ny = curr.y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if(visited[nx][ny])
					continue;
				if(map[nx][ny] == 0) {
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;
					len[nx][ny] = len[curr.x][curr.y] + 1; 
				}
				else if(map[nx][ny] != n) {
					min = Math.min(min, len[curr.x][curr.y]);
					flag = true;
					break;
				}
			}
			if(flag)
				break;
		}
	}
}
